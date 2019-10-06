package com.marco.controller.actors;

import com.marco.domain.actors.Driver;
import com.marco.factory.actors.DriverFactory;
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
public class DriverControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/driver";

    @Test
    public void a_create() {
        Driver driver = DriverFactory.buildDriver(32, "john", "poop");

        ResponseEntity<Driver> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", driver, Driver.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Driver driver = restTemplate.getForObject(baseURL + "/read/32", Driver.class); //Reading announcer with empNumber 55
        Driver updated = new Driver.Builder().copy(driver).surname("poopie").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        Driver updatedDriver = restTemplate.getForObject(baseURL + "/read/32", Driver.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedDriver);
        assertEquals(updated.getSurname(), updatedDriver.getSurname());
    }

    @Test
    public void e_delete() {
        Driver driver = restTemplate.getForObject(baseURL + "/read/32", Driver.class);
        assertNotNull(driver);
        assertEquals(32, driver.getEmployeeNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + driver.getEmployeeNumber());
        driver = restTemplate.getForObject(baseURL + "/read/32", Driver.class);

        assertNull(driver);
    }

    @Test
    public void b_read() {
        ResponseEntity<Driver> driverResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/32", Driver.class);
        assertNotNull(driverResponseEntity.getBody());
        assertEquals(32, driverResponseEntity.getBody().getEmployeeNumber());
    }

    @Test
    public void d_getAllDrivers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("DriverHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}