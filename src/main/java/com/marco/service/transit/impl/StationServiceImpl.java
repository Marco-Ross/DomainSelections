package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Station;
import com.marco.repository.transit.transitrepo.StationRepository;
import com.marco.service.transit.transitservice.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("StationServiceImpl")
public class StationServiceImpl implements StationService {
    @Autowired
    private StationRepository repository;

    @Override
    public Set<Station> getAllStations() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Station create(Station station) {
        return this.repository.save(station);
    }

    @Override
    public Station update(Station station) {
        return this.repository.save(station);
    }

    @Override
    public void delete(Integer station) {
        this.repository.deleteById(station);
    }

    @Override
    public Optional<Station> read(Integer station) {
        return this.repository.findById(station);
    }
}
