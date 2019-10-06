package com.marco.controller.actors;

import com.marco.domain.actors.Announcer;
import com.marco.factory.actors.AnnouncerFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class AnnouncerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/announcer";

    @Test
    public void a_create() {
        Announcer announcer = AnnouncerFactory.buildAnnouncer(55, "marco", "ross");
        //Create header to send username and password
        ResponseEntity<Announcer> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", announcer, Announcer.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Announcer announcer = restTemplate.getForObject(baseURL + "/read/55", Announcer.class); //Reading announcer with empNumber 55
        Announcer updated = new Announcer.Builder().copy(announcer).surname("newRoss").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        Announcer updatedAnnouncer = restTemplate.withBasicAuth("Kaylin", "pass02").getForObject(baseURL + "/read/55", Announcer.class); //Reading announcer with empNumber 55 to check if updated

        //assertTrue(HttpStatus.FORBIDDEN);
        assertNotNull(updatedAnnouncer);
        assertEquals("newRoss", updatedAnnouncer.getSurname());
    }

    @Test
    public void e_delete() {
        Announcer announcer = restTemplate.withBasicAuth("Kaylin", "pass02").getForObject(baseURL + "/read/55", Announcer.class);
        assertNotNull(announcer);
        assertEquals(55, announcer.getEmployeeNumber());

        restTemplate.delete(baseURL + "/delete/" + announcer.getEmployeeNumber());
        announcer = restTemplate.withBasicAuth("Kaylin", "pass02").getForObject(baseURL + "/read/55", Announcer.class);

        assertNull(announcer);
    }

    @Test
    public void b_read() {
        Announcer announcer = restTemplate.withBasicAuth("Marco", "pass01").getForObject(baseURL + "/read/55", Announcer.class);
        assertSame(55, announcer.getEmployeeNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("AnnouncerHeader", "This is the getAll header");

        //HttpResponse<String> response

        //GET does not support @RequestBody at endpoint
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}