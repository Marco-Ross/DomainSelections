package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Station;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface StationRepository extends CrudRepository<Station, Integer> {
}
