package com.marco.repository.repositoryinterfaces.transitrepo;

import com.marco.domain.transit.Station;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface StationRepository extends RepositoryGI<Station, Integer> {
    ArrayList<Station> getAllStations();
}
