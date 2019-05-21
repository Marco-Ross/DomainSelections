package com.marco.controller.actors;

import com.marco.domain.actors.DoorMan;
import com.marco.factory.actors.DoorManFactory;
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
public class DoorManControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/doorman";

    @Test
    public void a_create() {
        DoorMan doorMan = DoorManFactory.buildDoorMan("jason", "love", 32);

        ResponseEntity<DoorMan> postResponse = restTemplate.postForEntity(baseURL + "/create", doorMan, DoorMan.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        DoorMan doorMan = restTemplate.getForObject(baseURL + "/read/32", DoorMan.class);
        DoorMan updated = new DoorMan.Builder().copy(doorMan).surname("lovie").build();
        restTemplate.put(baseURL + "/update", updated);

        DoorMan updatedDoorMan = restTemplate.getForObject(baseURL + "/read/32", DoorMan.class);

        assertNotNull(updatedDoorMan);
        assertEquals(updated.getSurname(), updatedDoorMan.getSurname());
    }

    @Test
    public void e_delete() {
        DoorMan doorMan = restTemplate.getForObject(baseURL + "/read/32", DoorMan.class);
        assertNotNull(doorMan);
        assertEquals(32, doorMan.getEmployeeNumber());

        restTemplate.delete(baseURL + "/delete/" + doorMan.getEmployeeNumber());
        doorMan = restTemplate.getForObject(baseURL + "/read/32", DoorMan.class);

        assertNull(doorMan);
    }

    @Test
    public void b_read() {
        ResponseEntity<DoorMan> doorManResponseEntity = restTemplate.getForEntity(baseURL + "/read/32", DoorMan.class);
        assertNotNull(doorManResponseEntity.getBody());
        assertEquals(32, doorManResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("DoorManHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}