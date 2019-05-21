package com.marco.service.transit.impl;

import com.marco.domain.transit.Station;
import com.marco.repository.transit.impl.StationRepositoryImpl;
import com.marco.repository.transit.transitrepo.StationRepository;
import com.marco.service.transit.transitservice.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("StationServiceImpl")
public class StationServiceImpl implements StationService {
    @Autowired
    @Qualifier("StationRepoImpl")
    private StationRepository repository;

    @Override
    public Set<Station> getAllStations() {
        return this.repository.getAllStations();
    }

    @Override
    public Station create(Station station) {
        return this.repository.create(station);
    }

    @Override
    public Station update(Station station) {
        return this.repository.update(station);
    }

    @Override
    public void delete(Integer station) {
        this.repository.delete(station);
    }

    @Override
    public Station read(Integer station) {
        return this.repository.read(station);
    }
}
