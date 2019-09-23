package com.marco.controller.bookings;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.factory.bookings.OnlineBookingFactory;
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
public class OnlineBookingControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/onlinebooking";
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

        OnlineBooking onlineBooking = OnlineBookingFactory.buildOnlineBooking(13, bookedDate,5);

        ResponseEntity<OnlineBooking> postResponse = restTemplate.postForEntity(baseURL + "/create", onlineBooking, OnlineBooking.class); //USE EXCHANGE FOR NEXT CREATE
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        calendar.set(2019, 5, 1);
        Date date = calendar.getTime();
        Date bookedDate = DateUtil.truncateTime(date);

        OnlineBooking onlineBooking = restTemplate.getForObject(baseURL + "/read/13", OnlineBooking.class); //Reading announcer with empNumber 55
        OnlineBooking updated = new OnlineBooking.Builder().copy(onlineBooking).onlineBookingDate(bookedDate).build();
        restTemplate.put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        OnlineBooking updatedOnlineBooking = restTemplate.getForObject(baseURL + "/read/13", OnlineBooking.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedOnlineBooking);
        assertEquals(updated.getOnlineBookingDate(), updatedOnlineBooking.getOnlineBookingDate());
    }

    @Test
    public void e_delete() {
        OnlineBooking onlineBooking = restTemplate.getForObject(baseURL + "/read/13", OnlineBooking.class);
        assertNotNull(onlineBooking);
        assertEquals(13, onlineBooking.getOnlineBookingId());

        restTemplate.delete(baseURL + "/delete/" + onlineBooking.getOnlineBookingId());
        onlineBooking = restTemplate.getForObject(baseURL + "/read/13", OnlineBooking.class);

        assertNull(onlineBooking);
    }

    @Test
    public void b_read() {
        ResponseEntity<OnlineBooking> onlineBookingResponseEntity = restTemplate.getForEntity(baseURL + "/read/13", OnlineBooking.class);
        assertNotNull(onlineBookingResponseEntity);
        assertNotNull(onlineBookingResponseEntity.getBody());
        assertEquals(13, onlineBookingResponseEntity.getBody().getOnlineBookingId());
    }

    @Test
    public void d_getAllOnlineBookings() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("OnlineBookingHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}