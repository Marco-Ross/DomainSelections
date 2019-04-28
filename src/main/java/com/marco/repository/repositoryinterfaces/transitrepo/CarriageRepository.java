package com.marco.repository.repositoryinterfaces.transitrepo;

import com.marco.domain.transit.Carriage;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface CarriageRepository extends RepositoryGI<Carriage, Integer> {
    Set<Carriage> getAllCarriages();
}
