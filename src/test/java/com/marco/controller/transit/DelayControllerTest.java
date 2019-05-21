package com.marco.controller.transit;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Station;
import com.marco.factory.transit.DelayFactory;
import com.marco.factory.transit.StationFactory;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DelayControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/delay";

    @Test
    public void a_create() {
        Station station = StationFactory.buildStation("Stikland", 12);
        Delay delay = DelayFactory.buildDelay(10, station, "Man hit by train");

        ResponseEntity<Delay> postResponse = restTemplate.postForEntity(baseURL + "/create", delay, Delay.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Delay delay = restTemplate.getForObject(baseURL + "/read/10", Delay.class);
        Delay updated = new Delay.Builder().copy(delay).description("Man stabbed to death").build();
        restTemplate.put(baseURL + "/update", updated);

        Delay updatedDelay = restTemplate.getForObject(baseURL + "/read/10", Delay.class);

        assertNotNull(updatedDelay);
        assertEquals(updated.getDescription(), updatedDelay.getDescription());
    }

    @Test
    public void e_delete() {
        Delay delay = restTemplate.getForObject(baseURL + "/read/10", Delay.class);
        assertNotNull(delay);
        assertEquals(10, delay.getDelayId());

        restTemplate.delete(baseURL + "/delete/" + delay.getDelayId());
        delay = restTemplate.getForObject(baseURL + "/read/10", Delay.class);

        assertNull(delay);
    }

    @Test
    public void b_read() {
        ResponseEntity<Delay> delayResponseEntity = restTemplate.getForEntity(baseURL + "/read/10", Delay.class);
        assertNotNull(delayResponseEntity.getBody());
        assertEquals(10, delayResponseEntity.getBody().getDelayId());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("DelayHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}