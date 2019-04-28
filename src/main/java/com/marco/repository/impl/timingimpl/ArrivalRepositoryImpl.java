package com.marco.repository.impl.timingimpl;

import com.marco.domain.timings.Arrival;
import com.marco.repository.repositoryinterfaces.timingrepo.ArrivalRepository;

import java.util.HashSet;
import java.util.Set;

public class ArrivalRepositoryImpl implements ArrivalRepository {

    private static ArrivalRepositoryImpl repository = null;
    private Set<Arrival> arrivals;

    private ArrivalRepositoryImpl(){
        this.arrivals = new HashSet<>();
    }

    public static ArrivalRepositoryImpl getRepository(){
        if(repository == null) repository = new ArrivalRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Arrival> getAllArrivals() {
        return this.arrivals;
    }

    @Override
    public Arrival create(Arrival arrival) {
        this.arrivals.add(arrival);
        return arrival;
    }

    @Override
    public Arrival update(Arrival arrival) {
        for(Arrival arrivalA : arrivals){
            if(arrival.getArrivalId() == arrivalA.getArrivalId()){
                this.arrivals.remove(arrivalA);
                this.arrivals.add(arrival);
            }
        }
        return arrival;
    }

    @Override
    public void delete(Arrival arrival) {
        this.arrivals.remove(arrival);
    }

    @Override
    public Arrival read(String stationName) {
        Arrival arrival1 = null;
        for(Arrival arrivalA : arrivals){
            if(stationName.equals(arrivalA.getArrivalStation())){
                arrival1 = arrivalA;
            }
        }
        return arrival1;
    }
}
