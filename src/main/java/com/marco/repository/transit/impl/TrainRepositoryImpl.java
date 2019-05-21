package com.marco.repository.transit.impl;

import com.marco.domain.transit.Train;
import com.marco.repository.transit.transitrepo.TrainRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TrainRepoImpl")
public class TrainRepositoryImpl implements TrainRepository {
    private Map<Integer, Train> trains;

    private TrainRepositoryImpl(){
        this.trains = new HashMap<>();
    }

    @Override
    public Set<Train> getAllTrains() {
        Collection<Train> platforms = this.trains.values();
        Set<Train> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public Train create(Train train) {
        this.trains.put(train.getTrainNumber(), train);
        return this.trains.get(train.getTrainNumber());
    }

    @Override
    public Train update(Train train) {
        this.trains.replace(train.getTrainNumber(), train);
        return this.trains.get(train.getTrainNumber());
    }

    @Override
    public void delete(Integer trainNumb) {
        this.trains.remove(trainNumb);
    }

    @Override
    public Train read(Integer trainNumb) {
        return this.trains.get(trainNumb);
    }
}
