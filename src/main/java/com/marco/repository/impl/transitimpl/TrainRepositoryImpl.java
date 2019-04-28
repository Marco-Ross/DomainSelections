package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Train;
import com.marco.repository.repositoryinterfaces.transitrepo.TrainRepository;

import java.util.ArrayList;

public class TrainRepositoryImpl implements TrainRepository {
    private static TrainRepositoryImpl repository = null;
    private ArrayList<Train> trains;

    private TrainRepositoryImpl(){
        this.trains = new ArrayList<>();
    }

    public static TrainRepositoryImpl getRepository(){
        if(repository == null) repository = new TrainRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Train> getAllTrains() {
        return this.trains;
    }

    @Override
    public Train create(Train train) {
        this.trains.add(train);
        return train;
    }

    @Override
    public Train update(Train train) {
        for(int i = 0; i<trains.size();i++){
            if(train.getTrainNumber() == trains.get(i).getTrainNumber()){
                this.trains.set(i, train);
            }
        }
        return train;
    }

    @Override
    public void delete(Train train) {
        this.trains.remove(train);
    }

    @Override
    public Train read(Integer trainNumb) {
        Train train = null;
        for(Train trainA : trains){
            if(trainNumb == trainA.getTrainNumber()){
                train = trainA;
            }
        }
        return train;
    }
}
