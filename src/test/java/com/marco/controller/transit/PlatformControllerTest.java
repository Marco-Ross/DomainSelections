package com.marco.controller.transit;

import com.marco.domain.transit.Platform;
import com.marco.factory.transit.PlatformFactory;
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
public class PlatformControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/platform";

    @Test
    public void a_create() {
        Platform platform = PlatformFactory.buildPlatform(10, 12);

        ResponseEntity<Platform> postResponse = restTemplate.postForEntity(baseURL + "/create", platform, Platform.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Platform getPlatform = restTemplate.getForObject(baseURL + "/read/10", Platform.class);
        Platform updated = new Platform.Builder().copy(getPlatform).platformLength(11).build();
        restTemplate.put(baseURL + "/update", updated);

        Platform updatedPlatform = restTemplate.getForObject(baseURL + "/read/10", Platform.class);

        assertNotNull(updatedPlatform);
        assertEquals(updated.getPlatformLength(), updatedPlatform.getPlatformLength());
    }

    @Test
    public void e_delete() {
        Platform getPlatform = restTemplate.getForObject(baseURL + "/read/10", Platform.class);
        assertNotNull(getPlatform);
        assertEquals(10, getPlatform.getPlatformNumber());

        restTemplate.delete(baseURL + "/delete/" + getPlatform.getPlatformNumber());
        getPlatform = restTemplate.getForObject(baseURL + "/read/10", Platform.class);

        assertNull(getPlatform);
    }

    @Test
    public void b_read() {
        ResponseEntity<Platform> platformResponseEntity = restTemplate.getForEntity(baseURL + "/read/10", Platform.class);
        assertNotNull(platformResponseEntity.getBody());
        assertEquals(10, platformResponseEntity.getBody().getPlatformNumber());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("PlatformHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}