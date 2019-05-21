package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Route;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface RouteRepository extends RepositoryGI<Route, Integer> {
    Set<Route> getAllRoutes();
}
