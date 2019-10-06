package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Engine;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EngineRepository extends CrudRepository<Engine, Integer> {
}
