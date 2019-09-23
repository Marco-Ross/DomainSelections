package com.marco.controller.transit;

import com.marco.domain.transit.Train;
import com.marco.factory.transit.TrainFactory;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrainControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/train";
    private Train train;

    @Before
    public void setUp() throws Exception {
        train = TrainFactory.buildTrain("2530",200);
    }

    @Test
    public void a_create() {
        ResponseEntity<Train> postResponse = restTemplate.postForEntity(baseURL + "/create", train, Train.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Train getTrain = restTemplate.getForObject(baseURL + "/read/2530", Train.class);
        Train updated = new Train.Builder().copy(getTrain).capacity(30).build();
        restTemplate.put(baseURL + "/update", updated);

        Train updatedTrain = restTemplate.getForObject(baseURL + "/read/2530", Train.class);

        assertNotNull(updatedTrain);
        assertEquals(updated.getTrainNumber(), updatedTrain.getTrainNumber());
    }

    @Test
    public void e_delete() {
        Train getTrain = restTemplate.getForObject(baseURL + "/read/2530", Train.class);
        assertNotNull(getTrain);
        assertEquals("2530", getTrain.getTrainNumber());

        restTemplate.delete(baseURL + "/delete/" + getTrain.getTrainNumber());
        getTrain = restTemplate.getForObject(baseURL + "/read/2530", Train.class);

        assertNull(getTrain);
    }

    @Test
    public void b_read() {
        ResponseEntity<Train> trainResponseEntity = restTemplate.getForEntity(baseURL + "/read/" + train.getTrainNumber(), Train.class);
        assertNotNull(trainResponseEntity.getBody());
        assertEquals("2530", trainResponseEntity.getBody().getTrainNumber());
    }

    @Test
    public void d_getTrains() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("TrainHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}