package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Route;
import com.marco.repository.transit.transitrepo.RouteRepository;
import com.marco.service.transit.transitservice.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("RouteServiceImpl")
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository repository;

    @Override
    public Set<Route> getAllRoutes() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Route create(Route route) {
        return this.repository.save(route);
    }

    @Override
    public Route update(Route route) {
        return this.repository.save(route);
    }

    @Override
    public void delete(Integer route) {
        this.repository.deleteById(route);
    }

    @Override
    public Optional<Route> read(Integer route) {
        return this.repository.findById(route);
    }
}
