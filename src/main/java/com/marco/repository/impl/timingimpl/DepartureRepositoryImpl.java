package com.marco.repository.impl.timingimpl;

import com.marco.domain.timings.Departure;
import com.marco.repository.repositoryinterfaces.timingrepo.DepartureRepository;

import java.util.HashSet;
import java.util.Set;

public class DepartureRepositoryImpl implements DepartureRepository {
    private static DepartureRepositoryImpl repository = null;
    private Set<Departure> departures;

    private DepartureRepositoryImpl(){
        this.departures = new HashSet<>();
    }

    public static DepartureRepositoryImpl getRepository(){
        if(repository == null) repository = new DepartureRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Departure> getAllDepartures() {
        return this.departures;
    }

    @Override
    public Departure create(Departure departure) {
        this.departures.add(departure);
        return departure;
    }

    @Override
    public Departure update(Departure departure) {
        for(Departure departureA : departures){
            if(departure == departureA){
                this.departures.remove(departureA);
                this.departures.add(departure);
            }
        }
        return departure;
    }

    @Override
    public void delete(Departure departure) {
        this.departures.remove(departure);
    }

    @Override
    public Departure read(String station) {
        Departure departure = null;
        for(Departure departureA : departures){
            if(station.equals(departureA.getDepartureStation())){
                departure = departureA;
            }
        }
        return departure;
    }
}
