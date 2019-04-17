package com.marco.factory.transit;

import com.marco.domain.transit.Route;

public class RouteFactory {
    public static Route getRoute(String routeArea, String routeName){
        return new Route.Builder().routeArea(routeArea)
                .routeName(routeName)
                .build();
    }
}
