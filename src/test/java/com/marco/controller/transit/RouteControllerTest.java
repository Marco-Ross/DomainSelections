package com.marco.controller.transit;

import com.marco.domain.transit.Route;
import com.marco.factory.transit.RouteFactory;
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
public class RouteControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/route";

    @Test
    public void a_create() {
        Route route = RouteFactory.buildRoute(1, "NorthernLine");

        ResponseEntity<Route> postResponse = restTemplate.postForEntity(baseURL + "/create", route, Route.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Route getRoute = restTemplate.getForObject(baseURL + "/read/1", Route.class);
        Route updated = new Route.Builder().copy(getRoute).routeName("NorthLine").build();
        restTemplate.put(baseURL + "/update", updated);

        Route updatedRoute = restTemplate.getForObject(baseURL + "/read/1", Route.class);

        assertNotNull(updatedRoute);
        assertEquals(updated.getRouteName(), updatedRoute.getRouteName());
    }

    @Test
    public void e_delete() {
        Route getRoute = restTemplate.getForObject(baseURL + "/read/1", Route.class);
        assertNotNull(getRoute);
        assertEquals(1, getRoute.getRouteAreaCode());

        restTemplate.delete(baseURL + "/delete/" + getRoute.getRouteAreaCode());
        getRoute = restTemplate.getForObject(baseURL + "/read/1", Route.class);

        assertNull(getRoute);
    }

    @Test
    public void b_read() {
        ResponseEntity<Route> routeResponseEntity = restTemplate.getForEntity(baseURL + "/read/1", Route.class);
        assertNotNull(routeResponseEntity.getBody());
        assertEquals(1, routeResponseEntity.getBody().getRouteAreaCode());
    }

    @Test
    public void d_getAllRoutes() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("RouteHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}