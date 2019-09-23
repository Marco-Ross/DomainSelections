package com.marco.controller.transit;

import com.marco.domain.transit.Station;
import com.marco.factory.transit.StationFactory;
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
public class StationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/station";

    @Test
    public void a_create() {
        Station station = StationFactory.buildStation("Stikland", 12);

        ResponseEntity<Station> postResponse = restTemplate.postForEntity(baseURL + "/create", station, Station.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Station getGtation = restTemplate.getForObject(baseURL + "/read/12", Station.class);
        Station updated = new Station.Builder().copy(getGtation).stationName("Stockland").build();
        restTemplate.put(baseURL + "/update", updated);

        Station updatedStation = restTemplate.getForObject(baseURL + "/read/12", Station.class);

        assertNotNull(updatedStation);
        assertEquals(updated.getStationName(), updatedStation.getStationName());
    }

    @Test
    public void e_delete() {
        Station getStation = restTemplate.getForObject(baseURL + "/read/12", Station.class);
        assertNotNull(getStation);
        assertEquals(12, getStation.getStationNumber());

        restTemplate.delete(baseURL + "/delete/" + getStation.getStationNumber());
        getStation = restTemplate.getForObject(baseURL + "/read/12", Station.class);

        assertNull(getStation);
    }

    @Test
    public void b_read() {
        ResponseEntity<Station> reportResponseEntity = restTemplate.getForEntity(baseURL + "/read/12", Station.class);
        assertNotNull(reportResponseEntity.getBody());
        assertEquals(12, reportResponseEntity.getBody().getStationNumber());
    }

    @Test
    public void d_getAllStations() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("StationHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}