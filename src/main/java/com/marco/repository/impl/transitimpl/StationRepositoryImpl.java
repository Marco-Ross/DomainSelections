package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Station;
import com.marco.repository.repositoryinterfaces.transitrepo.StationRepository;

import java.util.ArrayList;

public class StationRepositoryImpl implements StationRepository {
    private static StationRepositoryImpl repository = null;
    private ArrayList<Station> stations;

    private StationRepositoryImpl(){
        this.stations = new ArrayList<>();
    }

    public static StationRepositoryImpl getRepository(){
        if(repository == null) repository = new StationRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Station> getAllStations() {
        return this.stations;
    }

    @Override
    public Station create(Station station) {
        this.stations.add(station);
        return station;
    }

    @Override
    public Station update(Station station) {
        for(int i = 0; i<stations.size();i++){
            if(station.getStationNumber() == stations.get(i).getStationNumber()){
                this.stations.set(i, station);
            }
        }
        return station;
    }

    @Override
    public void delete(Station station) {
        this.stations.remove(station);
    }

    @Override
    public Station read(Integer stationNumb) {
        Station station = null;
        for(Station stationA : stations){
            if(stationNumb == stationA.getStationNumber()){
                station = stationA;
            }
        }
        return station;
    }
}
