package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Train;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface TrainRepository extends RepositoryGI<Train, Integer> {
    Set<Train> getAllTrains();
}
