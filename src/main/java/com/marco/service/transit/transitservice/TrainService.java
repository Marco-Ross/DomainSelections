package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Train;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Set;

public interface TrainService extends ServiceGI<Train, Integer> {
    Set<Train> getAllTrains();
}
