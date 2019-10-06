package com.marco.controller.bookings;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.factory.bookings.OfflineBookingFactory;
import org.assertj.core.util.DateUtil;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class OfflineBookingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/offlinebooking";
    private Date bookedDate;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        Date date = calendar.getTime();
        bookedDate = DateUtil.truncateTime(date);
    }

    @Test
    public void a_create() {
        OfflineBooking offlineBooking = OfflineBookingFactory.buildOfflineBooking(13, bookedDate, 62);

        ResponseEntity<OfflineBooking> postResponse = restTemplate.postForEntity(baseURL + "/create", offlineBooking, OfflineBooking.class); //USE EXCHANGE FOR NEXT CREATE
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        OfflineBooking offlineBookingResponse = restTemplate.getForObject(baseURL + "/read/13", OfflineBooking.class);
        assertNotNull(offlineBookingResponse);

        OfflineBooking updated = new OfflineBooking.Builder().copy(offlineBookingResponse).offlineQuantityBooked(70).build();
        restTemplate.put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        OfflineBooking updatedOfflineBookingResponse = restTemplate.getForObject(baseURL + "/read/13", OfflineBooking.class);

        assertNotNull(updatedOfflineBookingResponse);
        assertEquals(updated.getOfflineQuantityBooked(), updatedOfflineBookingResponse.getOfflineQuantityBooked());
    }

    @Test
    public void e_delete() {
        OfflineBooking offlineBookingResponse = restTemplate.getForObject(baseURL + "/read/13", OfflineBooking.class);
        assertNotNull(offlineBookingResponse);
        assertEquals(bookedDate, offlineBookingResponse.getOfflineBookingDate());

        restTemplate.delete(baseURL + "/delete/" + offlineBookingResponse.getOfflineBookingID(), void.class);

        offlineBookingResponse = restTemplate.getForObject(baseURL + "/read/13", OfflineBooking.class);

        assertNull(offlineBookingResponse);
    }

    @Test
    public void b_read() {
        ResponseEntity<OfflineBooking> offlineBookingResponseEntity = restTemplate.getForEntity(baseURL + "/read/13", OfflineBooking.class);

        assertNotNull(offlineBookingResponseEntity.getBody());
        assertEquals(bookedDate, offlineBookingResponseEntity.getBody().getOfflineBookingDate());
    }

    @Test
    public void d_getAllOfflineBookings() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("OfflineBookingHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}