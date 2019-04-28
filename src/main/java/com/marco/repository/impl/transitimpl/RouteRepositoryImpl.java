package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Route;
import com.marco.repository.repositoryinterfaces.transitrepo.RouteRepository;

import java.util.ArrayList;

public class RouteRepositoryImpl implements RouteRepository {
    private static RouteRepositoryImpl repository = null;
    private ArrayList<Route> routes;

    private RouteRepositoryImpl(){
        this.routes = new ArrayList<>();
    }

    public static RouteRepositoryImpl getRepository(){
        if(repository == null) repository = new RouteRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Route> getAllRoutes() {
        return this.routes;
    }

    @Override
    public Route create(Route route) {
        this.routes.add(route);
        return route;
    }

    @Override
    public Route update(Route route) {
        for(int i = 0; i<routes.size();i++){
            if(route.getRouteAreaCode() == routes.get(i).getRouteAreaCode()){
                this.routes.set(i, route);
            }
        }
        return route;
    }

    @Override
    public void delete(Route route) {
        this.routes.remove(route);
    }

    @Override
    public Route read(Integer areaCode) {
        Route route = null;
        for(Route routeA : routes){
            if(areaCode == routeA.getRouteAreaCode()){
                route = routeA;
            }
        }
        return route;
    }
}
