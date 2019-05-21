package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Carriage;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface CarriageRepository extends RepositoryGI<Carriage, Integer> {
    Set<Carriage> getAllCarriages();
}
