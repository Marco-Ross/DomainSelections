package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Station;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Set;

public interface StationService extends ServiceGI<Station, Integer> {
    Set<Station> getAllStations();
}
