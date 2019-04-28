package com.marco.repository.repositoryinterfaces.transitrepo;

import com.marco.domain.transit.Route;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface RouteRepository extends RepositoryGI<Route, Integer> {
    ArrayList<Route> getAllRoutes();
}
