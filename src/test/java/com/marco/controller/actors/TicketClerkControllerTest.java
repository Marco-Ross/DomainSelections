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
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketClerkControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/ticketclerk";

    @Test
    public void a_create() {
        TicketClerk ticketClerk = TicketClerkFactory.buildTicketClerk("cinder", "block", 93);

        ResponseEntity<TicketClerk> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", ticketClerk, TicketClerk.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        TicketClerk ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class); //Reading announcer with empNumber 55
        TicketClerk updated = new TicketClerk.Builder().copy(ticketClerk).surname("blocks").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        TicketClerk updatedTicketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedTicketClerk);
        assertEquals(updated.getSurname(), updatedTicketClerk.getSurname());
    }

    @Test
    public void e_delete() {
        TicketClerk ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class);
        assertNotNull(ticketClerk);
        assertEquals(93, ticketClerk.getEmployeeNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + ticketClerk.getEmployeeNumber());
        ticketClerk = restTemplate.getForObject(baseURL + "/read/93", TicketClerk.class);

        assertNull(ticketClerk);
    }

    @Test
    public void b_read() {
        ResponseEntity<TicketClerk> ticketClerkResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/93", TicketClerk.class);
        assertNotNull(ticketClerkResponseEntity.getBody());
        assertEquals(93, ticketClerkResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllTicketClerks() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("TicketClerkHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}