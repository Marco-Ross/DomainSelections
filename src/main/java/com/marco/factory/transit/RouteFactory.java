package com.marco.factory.transit;

import com.marco.domain.transit.Route;

public class RouteFactory {
    public static Route buildRoute(int routeAreaCode, String routeName){
        return new Route.Builder().routeAreaCode(routeAreaCode)
                .routeName(routeName)
                .build();
    }
}
