package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Station;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface StationRepository extends RepositoryGI<Station, Integer> {
    Set<Station> getAllStations();
}
