package com.marco.controller.actors;

import com.marco.domain.actors.Manager;
import com.marco.factory.actors.ManagerFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManagerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/manager";

    @Test
    public void a_create() {
        Manager manager = ManagerFactory.buildManager("john", "poop", 32);

        ResponseEntity<Manager> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", manager, Manager.class);

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Manager manager = restTemplate.getForObject(baseURL + "/read/32", Manager.class);
        Manager updated = new Manager.Builder().copy(manager).surname("poopie").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated);

        Manager updatedManager = restTemplate.getForObject(baseURL + "/read/32", Manager.class);

        assertNotNull(updatedManager);
        assertEquals(updated.getSurname(), updatedManager.getSurname());
    }

    @Test
    public void e_delete() {
        Manager manager = restTemplate.getForObject(baseURL + "/read/32", Manager.class);
        assertNotNull(manager);
        assertEquals(32, manager.getEmployeeNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + manager.getEmployeeNumber());
        manager = restTemplate.getForObject(baseURL + "/read/32", Manager.class);

        assertNull(manager);
    }

    @Test
    public void b_read() {
        ResponseEntity<Manager> managerResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/32", Manager.class);
        assertNotNull(managerResponseEntity.getBody());
        assertEquals(32, managerResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllMangers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ManagerHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}