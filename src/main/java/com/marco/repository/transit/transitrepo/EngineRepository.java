package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Engine;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface EngineRepository extends RepositoryGI<Engine, Integer> {
    ArrayList<Engine> getAllEngines();
}
