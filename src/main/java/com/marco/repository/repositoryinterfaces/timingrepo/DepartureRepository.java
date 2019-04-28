package com.marco.repository.repositoryinterfaces.timingrepo;

import com.marco.domain.timings.Departure;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface DepartureRepository extends RepositoryGI<Departure, String> {
    Set<Departure> getAllDepartures();
}
