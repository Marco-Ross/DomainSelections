package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Engine;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface EngineService extends ServiceGI<Engine, Integer, Optional<Engine>> {
    ArrayList<Engine> getAllEngines();
}
