package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Carriage;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CarriageRepository extends CrudRepository<Carriage, Integer> {
}
