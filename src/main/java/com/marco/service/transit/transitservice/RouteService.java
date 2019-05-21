package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Route;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Set;

public interface RouteService extends ServiceGI<Route, Integer> {
    Set<Route> getAllRoutes();
}
