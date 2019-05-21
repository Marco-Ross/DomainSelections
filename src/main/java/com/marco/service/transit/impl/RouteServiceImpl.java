package com.marco.service.transit.impl;

import com.marco.domain.transit.Route;
import com.marco.repository.transit.impl.RouteRepositoryImpl;
import com.marco.repository.transit.transitrepo.RouteRepository;
import com.marco.service.transit.transitservice.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("RouteServiceImpl")
public class RouteServiceImpl implements RouteService {
    @Autowired
    @Qualifier("RouteRepoImpl")
    private RouteRepository repository;

    @Override
    public Set<Route> getAllRoutes() {
        return this.repository.getAllRoutes();
    }

    @Override
    public Route create(Route route) {
        return this.repository.create(route);
    }

    @Override
    public Route update(Route route) {
        return this.repository.update(route);
    }

    @Override
    public void delete(Integer route) {
        this.repository.delete(route);
    }

    @Override
    public Route read(Integer route) {
        return this.repository.read(route);
    }
}
