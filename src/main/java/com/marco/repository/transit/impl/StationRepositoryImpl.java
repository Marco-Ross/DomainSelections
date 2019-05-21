package com.marco.repository.transit.impl;

import com.marco.domain.transit.Station;
import com.marco.repository.transit.transitrepo.StationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("StationRepoImpl")
public class StationRepositoryImpl implements StationRepository {
    private Map<Integer, Station> stations;

    private StationRepositoryImpl(){
        this.stations = new HashMap<>();
    }

    @Override
    public Set<Station> getAllStations() {
        Collection<Station> platforms = this.stations.values();
        Set<Station> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public Station create(Station station) {
        this.stations.put(station.getStationNumber(), station);
        return this.stations.get(station.getStationNumber());
    }

    @Override
    public Station update(Station station) {
        this.stations.replace(station.getStationNumber(), station);
        return this.stations.get(station.getStationNumber());
    }

    @Override
    public void delete(Integer stationNumb) {
        this.stations.remove(stationNumb);
    }

    @Override
    public Station read(Integer stationNumb) {
        return this.stations.get(stationNumb);
    }
}
