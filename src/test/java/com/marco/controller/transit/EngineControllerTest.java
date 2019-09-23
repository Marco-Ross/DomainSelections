package com.marco.controller.transit;

import com.marco.domain.transit.Engine;
import com.marco.factory.transit.EngineFactory;
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
public class EngineControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/engine";

    @Test
    public void a_create() {
        Engine engine = EngineFactory.buildEngine(2553, "Royce");

        ResponseEntity<Engine> postResponse = restTemplate.postForEntity(baseURL + "/create", engine, Engine.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Engine getEngine = restTemplate.getForObject(baseURL + "/read/2553", Engine.class);
        Engine updated = new Engine.Builder().copy(getEngine).modelName("Superfast").build();
        restTemplate.put(baseURL + "/update", updated);

        Engine updatedEngine = restTemplate.getForObject(baseURL + "/read/2553", Engine.class);

        assertNotNull(updatedEngine);
        assertEquals(updated.getModelName(), updatedEngine.getModelName());
    }

    @Test
    public void e_delete() {
        Engine getEngine = restTemplate.getForObject(baseURL + "/read/2553", Engine.class);
        assertNotNull(getEngine);
        assertEquals(2553, getEngine.getEngineNumber());

        restTemplate.delete(baseURL + "/delete/" + getEngine.getEngineNumber());
        getEngine = restTemplate.getForObject(baseURL + "/read/2553", Engine.class);

        assertNull(getEngine);
    }

    @Test
    public void b_read() {
        ResponseEntity<Engine> engineResponseEntity = restTemplate.getForEntity(baseURL + "/read/2553", Engine.class);
        assertNotNull(engineResponseEntity.getBody());
        assertEquals(2553, engineResponseEntity.getBody().getEngineNumber());
    }

    @Test
    public void d_getAllEngines() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("EngineHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}