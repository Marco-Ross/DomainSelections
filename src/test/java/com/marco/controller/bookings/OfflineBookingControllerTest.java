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
        OfflineBooking offlineBooking = OfflineBookingFactory.buildOfflineBooking(bookedDate, 62);

        ResponseEntity<OfflineBooking> postResponse = restTemplate.postForEntity(baseURL + "/create", offlineBooking, OfflineBooking.class); //USE EXCHANGE FOR NEXT CREATE
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        ResponseEntity<OfflineBooking> offlineBookingResponseEntity = restTemplate.postForEntity(baseURL + "/read", bookedDate, OfflineBooking.class);
        assertNotNull(offlineBookingResponseEntity.getBody());

        OfflineBooking updated = new OfflineBooking.Builder().copy(offlineBookingResponseEntity.getBody()).offlineQuantityBooked(70).build();
        restTemplate.put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        ResponseEntity<OfflineBooking> updatedOfflineBookingResponseEntity = restTemplate.postForEntity(baseURL + "/read", bookedDate, OfflineBooking.class);

        assertNotNull(updatedOfflineBookingResponseEntity.getBody());
        assertEquals(updated.getOfflineQuantityBooked(), updatedOfflineBookingResponseEntity.getBody().getOfflineQuantityBooked());
    }

    @Test
    public void e_delete() {
        ResponseEntity<OfflineBooking> offlineBookingResponseEntity = restTemplate.postForEntity(baseURL + "/read", bookedDate, OfflineBooking.class);
        assertNotNull(offlineBookingResponseEntity.getBody());
        assertEquals(bookedDate, offlineBookingResponseEntity.getBody().getOfflineBookingDate());

        restTemplate.postForEntity(baseURL + "/delete", bookedDate, void.class);

        offlineBookingResponseEntity = restTemplate.postForEntity(baseURL + "/read", bookedDate, OfflineBooking.class);

        assertNull(offlineBookingResponseEntity.getBody());
    }

    @Test
    public void b_read() {
        ResponseEntity<OfflineBooking> offlineBookingResponseEntity = restTemplate.postForEntity(baseURL + "/read", bookedDate, OfflineBooking.class);

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