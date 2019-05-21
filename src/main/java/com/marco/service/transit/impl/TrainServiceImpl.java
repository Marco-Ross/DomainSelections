package com.marco.service.transit.impl;

import com.marco.domain.transit.Train;
import com.marco.repository.transit.impl.TrainRepositoryImpl;
import com.marco.repository.transit.transitrepo.TrainRepository;
import com.marco.service.transit.transitservice.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("TrainServiceImpl")
public class TrainServiceImpl implements TrainService {
    @Autowired
    @Qualifier("TrainRepoImpl")
    private TrainRepository repository;

    @Override
    public Set<Train> getAllTrains() {
        return this.repository.getAllTrains();
    }

    @Override
    public Train create(Train train) {
        return this.repository.create(train);
    }

    @Override
    public Train update(Train train) {
        return this.repository.update(train);
    }

    @Override
    public void delete(Integer train) {
        this.repository.delete(train);
    }

    @Override
    public Train read(Integer train) {
        return this.repository.read(train);
    }
}
