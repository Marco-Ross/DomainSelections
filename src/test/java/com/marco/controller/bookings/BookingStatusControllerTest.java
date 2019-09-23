package com.marco.controller.bookings;

import com.marco.domain.bookings.BookingStatus;
import com.marco.factory.bookings.BookingStatusFactory;
import org.assertj.core.util.DateUtil;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingStatusControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/bookingstatus";
    private Calendar calendar;

    @Before
    public void setUp() throws Exception {
        calendar = Calendar.getInstance();
    }

    @Test
    public void a_create() {
        calendar.set(2019, 4, 31);
        Date date = calendar.getTime();
        Date bookedDate = DateUtil.truncateTime(date);

        BookingStatus bookingStatus = BookingStatusFactory.buildBookingStatus(553, bookedDate);

        ResponseEntity<BookingStatus> postResponse = restTemplate.postForEntity(baseURL + "/create", bookingStatus, BookingStatus.class); //USE EXCHANGE FOR NEXT CREATE
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        calendar.set(2019, 5, 1);
        Date date = calendar.getTime();
        Date bookedDate = DateUtil.truncateTime(date);

        BookingStatus bookingStatus = restTemplate.getForObject(baseURL + "/read/553", BookingStatus.class); //Reading announcer with empNumber 55
        BookingStatus updated = new BookingStatus.Builder().copy(bookingStatus).timesBooked(bookedDate).build();
        restTemplate.put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        BookingStatus updatedBookingStatus = restTemplate.getForObject(baseURL + "/read/553", BookingStatus.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedBookingStatus);
        assertEquals(updated.getTimesBooked(), updatedBookingStatus.getTimesBooked());
    }

    @Test
    public void e_delete() {
        BookingStatus bookingStatus = restTemplate.getForObject(baseURL + "/read/553", BookingStatus.class);
        assertNotNull(bookingStatus);
        assertEquals(553, bookingStatus.getBookingId());

        restTemplate.delete(baseURL + "/delete/" + bookingStatus.getBookingId());
        bookingStatus = restTemplate.getForObject(baseURL + "/read/553", BookingStatus.class);

        assertNull(bookingStatus);
    }

    @Test
    public void b_read() {
        ResponseEntity<BookingStatus> bookingStatusResponseEntity = restTemplate.getForEntity(baseURL + "/read/553", BookingStatus.class);
        assertNotNull(bookingStatusResponseEntity.getBody());
        assertEquals(553, bookingStatusResponseEntity.getBody().getBookingId());
    }

    @Test
    public void d_getAllBookingStatus() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("BookingStatusHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}