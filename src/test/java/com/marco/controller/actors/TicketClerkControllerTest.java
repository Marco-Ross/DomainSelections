package com.marco.controller.actors;

import com.marco.domain.actors.TicketClerk;
import com.marco.factory.actors.TicketClerkFactory;
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
public class TicketClerkControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/ticketclerk";

    @Test
    public void a_create() {
        TicketClerk ticketClerk = TicketClerkFactory.buildTicketClerk("cinder", "block", 93);

        ResponseEntity<TicketClerk> postResponse = restTemplate.postForEntity(baseURL + "/create", ticketClerk, TicketClerk.class); //USE EXCHANGE FOR NEXT CREATE
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        TicketClerk ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class); //Reading announcer with empNumber 55
        TicketClerk updated = new TicketClerk.Builder().copy(ticketClerk).surname("blocks").build();
        restTemplate.put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        TicketClerk updatedTicketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedTicketClerk);
        assertEquals(updated.getSurname(), updatedTicketClerk.getSurname());
    }

    @Test
    public void e_delete() {
        TicketClerk ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class);
        assertNotNull(ticketClerk);
        assertEquals(93, ticketClerk.getEmployeeNumber());

        restTemplate.delete(baseURL + "/delete/" + ticketClerk.getEmployeeNumber());
        ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class);

        assertNull(ticketClerk);
    }

    @Test
    public void b_read() {
        ResponseEntity<TicketClerk> ticketClerkResponseEntity = restTemplate.getForEntity(baseURL + "/read/93", TicketClerk.class);
        assertNotNull(ticketClerkResponseEntity.getBody());
        assertEquals(93, ticketClerkResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("TicketClerkHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}