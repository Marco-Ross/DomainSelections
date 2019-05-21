package com.marco.factory.transit;

import com.marco.domain.transit.Route;
import org.junit.Test;

import static org.junit.Assert.*;

public class RouteFactoryTest {

    @Test
    public void getRoute() {
        int routeAreaCode = 2;
        String routeName = "Northern";
        Route route = RouteFactory.buildRoute(routeAreaCode, routeName);
        assertEquals(routeAreaCode, route.getRouteAreaCode());
    }
}