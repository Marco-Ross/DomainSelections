package com.marco.repository.transit.impl;

import com.marco.domain.transit.Train;
import com.marco.repository.transit.transitrepo.TrainRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TrainRepoImpl")
public class TrainRepositoryImpl implements TrainRepository {
    private Map<String, Train> trains;

    private TrainRepositoryImpl(){
        this.trains = new HashMap<>();
    }

    @Override
    public Set<Train> getAllTrains() {
        Collection<Train> platforms = this.trains.values();
        return new HashSet<>(platforms);
    }

    @Override
    public Train create(Train train) {
        for(Train trainA : getAllTrains()){
            if(train.getTrainNumber().equals(trainA.getTrainNumber())){
                return this.trains.get(trainA.getTrainID());
            }
        }
        this.trains.put(train.getTrainID(), train);
        return this.trains.get(train.getTrainID());
    }

    @Override
    public Train update(Train train) {
        this.trains.replace(train.getTrainID(), train);
        return this.trains.get(train.getTrainID());
    }

    @Override
    public void delete(String trainNumber) {
        for(Train trainA : getAllTrains()){
            if(trainNumber.equals(trainA.getTrainNumber())){
                this.trains.remove(trainA.getTrainID());
            }
        }
    }

    @Override
    public Train read(String trainNumber) {
        for(Train trainA : getAllTrains()){
            if(trainNumber.equals(trainA.getTrainNumber())){
                return this.trains.get(trainA.getTrainID());
            }
        }
        return this.trains.get(trainNumber);
    }
}
