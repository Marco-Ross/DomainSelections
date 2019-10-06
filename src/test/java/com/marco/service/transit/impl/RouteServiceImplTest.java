package com.marco.service.transit.impl;

import com.marco.domain.transit.Route;
import com.marco.factory.transit.RouteFactory;
import com.marco.service.transit.transitservice.RouteService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RouteServiceImplTest {
    @Autowired
    @Qualifier("RouteServiceImpl")
    private RouteService service;
    private Route route;

    private Route getRepo(){
        for(Route routeA : service.getAllRoutes()){
            if(routeA.getRouteAreaCode() == route.getRouteAreaCode()){
                return routeA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        route = RouteFactory.buildRoute(1, "NorthernLine");
    }

    @Test
    public void d_getAllRoutes() {
        Set<Route> arrayList = service.getAllRoutes();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Route routeTest = this.service.create(route);

        Assert.assertEquals(route.getRouteAreaCode(), routeTest.getRouteAreaCode());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String routeName = "SouthernLine";
        Route updated = new Route.Builder().copy(getRepo()).routeName(routeName).build();

        this.service.update(updated);

        Assert.assertEquals(routeName, updated.getRouteName());
        System.out.println("Route updated");
    }

    @Test
    public void e_delete() {
        service.delete(route.getRouteAreaCode());
        Set<Route> routes = service.getAllRoutes();
        Assert.assertEquals(0, routes.size());
    }

    @Test
    public void b_read() {
        Optional<Route> routeRead = service.read(1);
        Assert.assertTrue(routeRead.isPresent());
        Assert.assertEquals(route.getRouteAreaCode(), routeRead.get().getRouteAreaCode());
    }
}