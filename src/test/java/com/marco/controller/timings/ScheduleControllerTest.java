package com.marco.controller.timings;

import com.marco.domain.timings.NewSchedule;
import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.NewScheduleFactory;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.transit.TrainFactory;
import com.marco.service.transit.transitservice.TrainService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.Format;
import java.text.SimpleDateFormat;
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
    private NewSchedule newSchedule;

    @Autowired
    @Qualifier("TrainServiceImpl")
    private TrainService trainService;

    @Before
    public void setUp() throws Exception {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(2006, 1, 3,4,5,0);
        arrive.set(2006,1,3,5,0,0);
        Date departureTime = depart.getTime();
        Date arrivalTime = arrive.getTime();

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String departureString = formatter.format(departureTime);
        String arrivalString = formatter.format(arrivalTime);

        newSchedule = NewScheduleFactory.buildNewSchedule("2530", 200, departureString, arrivalString);
    }

    @Test
    public void a_create() {
        Train train = TrainFactory.buildTrain("2530",200);
        ResponseEntity<Train> trainPostResponse = restTemplate.postForEntity("http://localhost:8080/railway/train/create", train, Train.class);
        assertNotNull(trainPostResponse);
        assertNotNull(trainPostResponse.getBody());

        ResponseEntity<NewSchedule> postResponse = restTemplate.postForEntity(baseURL + "/create", newSchedule, NewSchedule.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_updateTrainAtTime() {
        NewSchedule getTrain = restTemplate.getForObject(baseURL + "/readTrain/" + newSchedule.getTrainNumber(), NewSchedule.class);

        restTemplate.postForEntity(baseURL + "/old", newSchedule, NewSchedule.class);
        NewSchedule updated = new NewSchedule.Builder().copy(getTrain).trainNumber("3520").build();


        restTemplate.put(baseURL + "/update", updated);

        NewSchedule updatedSchedule = restTemplate.getForObject(baseURL + "/read/" + newSchedule.getDeparture(), NewSchedule.class);
        System.out.println(updatedSchedule.getTrainNumber());

        assertNotNull(updatedSchedule);
        assertEquals(updated.getDeparture(), updatedSchedule.getDeparture());
    }

    @Test
    public void e_delete() {
        NewSchedule getTrain = restTemplate.getForObject(baseURL + "/readTrain/3520", NewSchedule.class);
        assertNotNull(getTrain);
        assertEquals("3520", getTrain.getTrainNumber());

        restTemplate.postForEntity(baseURL + "/old", newSchedule, NewSchedule.class);

        restTemplate.delete(baseURL + "/delete/" + getTrain.getTrainNumber());
        getTrain = restTemplate.getForObject(baseURL + "/read/" + newSchedule.getTrainNumber(), NewSchedule.class);

        assertNull(getTrain);
    }

    @Test
    public void b_read() { //Return all trains at this time
        ResponseEntity<NewSchedule> scheduleResponseEntity = restTemplate.getForEntity(baseURL + "/read/" + newSchedule.getDeparture(), NewSchedule.class);
        assertNotNull(scheduleResponseEntity.getBody());
        assertEquals("2530", scheduleResponseEntity.getBody().getTrainNumber());
    }

    @Test
    public void d_getAllSchedules() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ScheduleHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}