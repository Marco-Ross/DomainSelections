package com.marco.controller.timings;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.transit.TrainFactory;
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
public class ScheduleControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/schedule";
    private Schedule schedule;

    @Before
    public void setUp() throws Exception {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(2006, 1, 3,4,5,0);
        arrive.set(2006,1,3,5,0,0);
        Date departureTime = depart.getTime();
        Date arrivalTime = arrive.getTime();

        Train train = TrainFactory.buildTrain(2553, 145, "Kenny");

        schedule = ScheduleFactory.buildSchedule(departureTime, arrivalTime, train);
    }

    @Test
    public void a_create() {
        ResponseEntity<Schedule> postResponse = restTemplate.postForEntity(baseURL + "/create", schedule, Schedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Calendar depart = Calendar.getInstance();
        depart.set(2006, 1, 3,4,15,0);
        Date departureTime = depart.getTime();

        Schedule getSchedule = restTemplate.getForObject(baseURL + "/read/" + schedule.getTrain().getTrainNumber(), Schedule.class);
        Schedule updated = new Schedule.Builder().copy(getSchedule).departure(departureTime).build();
        restTemplate.put(baseURL + "/update", updated);


        Schedule updatedSchedule = restTemplate.getForObject(baseURL + "/read/" + schedule.getTrain().getTrainNumber(), Schedule.class);

        assertNotNull(updatedSchedule);
        assertEquals(updated.getTrain().getTrainNumber(), updatedSchedule.getTrain().getTrainNumber());
    }

    @Test
    public void e_delete() {
        Schedule getSchedule = restTemplate.getForObject(baseURL + "/read/" + schedule.getTrain().getTrainNumber(), Schedule.class);
        assertNotNull(getSchedule);
        assertEquals(2553, getSchedule.getTrain().getTrainNumber());

        restTemplate.delete(baseURL + "/delete/" + getSchedule.getTrain().getTrainNumber());
        getSchedule = restTemplate.getForObject(baseURL + "/read/" + schedule.getTrain().getTrainNumber(), Schedule.class);

        assertNull(getSchedule);
    }

    @Test
    public void b_read() {
        ResponseEntity<Schedule> scheduleResponseEntity = restTemplate.getForEntity(baseURL + "/read/" + schedule.getTrain().getTrainNumber(), Schedule.class);
        assertNotNull(scheduleResponseEntity.getBody());
        assertEquals(2553, scheduleResponseEntity.getBody().getTrain().getTrainNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ScheduleHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}