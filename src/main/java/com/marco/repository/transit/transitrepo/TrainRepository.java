package com.marco.repository.transit.transitrepo;

import com.marco.domain.timings.NewSchedule;
import com.marco.domain.transit.Train;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public interface TrainRepository extends RepositoryGI<Train, String> {
    Set<Train> getAllTrains();
}
