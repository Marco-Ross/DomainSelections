package com.marco.controller.actors;

import com.marco.domain.actors.Security;
import com.marco.factory.actors.SecurityFactory;
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
public class SecurityControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/security";

    @Test
    public void a_create() {
        Security security = SecurityFactory.buildSecurity(48, "cinder", "block");

        ResponseEntity<Security> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", security, Security.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Security security = restTemplate.getForObject(baseURL + "/read/48", Security.class); //Reading announcer with empNumber 55
        Security updated = new Security.Builder().copy(security).surname("poopie").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        Security updatedSecurity = restTemplate.getForObject(baseURL + "/read/48", Security.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedSecurity);
        assertEquals(updated.getSurname(), updatedSecurity.getSurname());
    }

    @Test
    public void e_delete() {
        Security security = restTemplate.getForObject(baseURL + "/read/48", Security.class);
        assertNotNull(security);
        assertEquals(48, security.getEmployeeNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + security.getEmployeeNumber());
        security = restTemplate.getForObject(baseURL + "/read/48", Security.class);

        assertNull(security);
    }

    @Test
    public void b_read() {
        ResponseEntity<Security> securityResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/48", Security.class);
        assertNotNull(securityResponseEntity.getBody());
        assertEquals(48, securityResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllSecurity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("SecurityHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}