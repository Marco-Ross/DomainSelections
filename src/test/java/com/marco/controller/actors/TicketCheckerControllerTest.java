package com.marco.controller.actors;

import com.marco.domain.actors.TicketChecker;
import com.marco.factory.actors.TicketCheckerFactory;
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
public class TicketCheckerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/ticketchecker";

    @Test
    public void a_create() {
        TicketChecker ticketChecker = TicketCheckerFactory.buildTicketChecker("cinder", "block", 48);

        ResponseEntity<TicketChecker> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", ticketChecker, TicketChecker.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        TicketChecker ticketChecker = restTemplate.getForObject(baseURL + "/read/48", TicketChecker.class); //Reading announcer with empNumber 55
        TicketChecker updated = new TicketChecker.Builder().copy(ticketChecker).surname("poopie").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        TicketChecker updatedTicketChecker = restTemplate.getForObject(baseURL + "/read/48", TicketChecker.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedTicketChecker);
        assertEquals(updated.getSurname(), updatedTicketChecker.getSurname());
    }

    @Test
    public void e_delete() {
        TicketChecker ticketChecker = restTemplate.getForObject(baseURL + "/read/48", TicketChecker.class);
        assertNotNull(ticketChecker);
        assertEquals(48, ticketChecker.getEmployeeNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + ticketChecker.getEmployeeNumber());
        ticketChecker = restTemplate.getForObject(baseURL + "/read/48", TicketChecker.class);

        assertNull(ticketChecker);
    }

    @Test
    public void b_read() {
        ResponseEntity<TicketChecker> ticketCheckerResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/48", TicketChecker.class);
        assertNotNull(ticketCheckerResponseEntity.getBody());
        assertEquals(48, ticketCheckerResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllTicketCheckers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("TicketCheckerHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}