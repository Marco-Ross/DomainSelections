package com.marco.controller.transit;

import com.marco.domain.transit.Carriage;
import com.marco.factory.transit.CarriageFactory;
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
public class CarriageControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/carriage";

    @Test
    public void a_create() {
        Carriage carriage = CarriageFactory.buildCarriage(12, 50);

        ResponseEntity<Carriage> postResponse = restTemplate.postForEntity(baseURL + "/create", carriage, Carriage.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Carriage carriage = restTemplate.getForObject(baseURL + "/read/12", Carriage.class);
        Carriage updated = new Carriage.Builder().copy(carriage).capacity(40).build();
        restTemplate.put(baseURL + "/update", updated);

        Carriage updatedCarriage = restTemplate.getForObject(baseURL + "/read/12", Carriage.class);

        assertNotNull(updatedCarriage);
        assertEquals(updated.getCarriageNumber(), updatedCarriage.getCarriageNumber());
    }

    @Test
    public void e_delete() {
        Carriage carriage = restTemplate.getForObject(baseURL + "/read/12", Carriage.class);
        assertNotNull(carriage);
        assertEquals(12, carriage.getCarriageNumber());

        restTemplate.delete(baseURL + "/delete/" + carriage.getCarriageNumber());
        carriage = restTemplate.getForObject(baseURL + "/read/12", Carriage.class);

        assertNull(carriage);
    }

    @Test
    public void b_read() {
        ResponseEntity<Carriage> carriageResponseEntity = restTemplate.getForEntity(baseURL + "/read/12", Carriage.class);
        assertNotNull(carriageResponseEntity.getBody());
        assertEquals(12, carriageResponseEntity.getBody().getCarriageNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("CarriageHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}