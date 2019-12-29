package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Train;
import com.marco.repository.transit.transitrepo.TrainRepository;
import com.marco.service.transit.transitservice.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;

@Service("TrainServiceImpl")
public class TrainServiceImpl implements TrainService {
    @Autowired
    private TrainRepository repository;

    @Override
    public Set<Train> getAllTrains() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Train create(Train train) {
        if(getTrainWithTrainNumber(train.getTrainNumber()) != null){
            return null;
        }
        return this.repository.save(train);
    }

    @Override
    public Train update(Train train) {
        return this.repository.save(train);
    }

    @Override
    public void delete(Integer trainNumber) {
        this.repository.deleteById(getTrainWithTrainNumber(trainNumber).getTrainID());
    }

    @Override
    public Optional<Train> read(Integer trainNumber) {
        if(getTrainWithTrainNumber(trainNumber) == null){
            return Optional.empty();
        }
        return this.repository.findById(getTrainWithTrainNumber(trainNumber).getTrainID());
    }

    @Override
    public Train getTrainWithTrainNumber(int trainNumber){
                for(Train train : repository.findAll()){
                    if(train.getTrainNumber() == trainNumber){
                        Optional<Train> optTrain = repository.findById(train.getTrainID());
                        return optTrain.orElse(null);
                    }
                }
           return null;
    }
}
