package com.marco.factory.transit;

import com.marco.domain.transit.Route;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteFactoryTest {

    @Test
    public void getRoute() {
        String routeArea = "Bellville";
        String routeName = "Northern";
        Route route = RouteFactory.getRoute(routeArea, routeName);
        assertNotNull(route.getRouteArea());
    }
}