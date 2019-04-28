package com.marco.repository.repositoryinterfaces.transitrepo;

import com.marco.domain.transit.Train;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface TrainRepository extends RepositoryGI<Train, Integer> {
    ArrayList<Train> getAllTrains();
}
