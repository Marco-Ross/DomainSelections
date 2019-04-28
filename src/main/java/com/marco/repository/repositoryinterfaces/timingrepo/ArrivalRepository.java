package com.marco.repository.repositoryinterfaces.timingrepo;

import com.marco.domain.timings.Arrival;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface ArrivalRepository extends RepositoryGI<Arrival, String> {
    Set<Arrival> getAllArrivals();
}
