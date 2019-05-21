package com.marco.repository.transit.impl;

import com.marco.domain.transit.Route;
import com.marco.repository.transit.transitrepo.RouteRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("RouteRepoImpl")
public class RouteRepositoryImpl implements RouteRepository {
    private Map<Integer, Route> routes;

    private RouteRepositoryImpl(){
        this.routes = new HashMap<>();
    }

    @Override
    public Set<Route> getAllRoutes() {
        Collection<Route> platforms = this.routes.values();
        Set<Route> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public Route create(Route route) {
        this.routes.put(route.getRouteAreaCode(), route);
        return this.routes.get(route.getRouteAreaCode());
    }

    @Override
    public Route update(Route route) {
        this.routes.replace(route.getRouteAreaCode(), route);
        return this.routes.get(route.getRouteAreaCode());
    }

    @Override
    public void delete(Integer areaCode) {
        this.routes.remove(areaCode);
    }

    @Override
    public Route read(Integer areaCode) {
        return this.routes.get(areaCode);
    }
}
