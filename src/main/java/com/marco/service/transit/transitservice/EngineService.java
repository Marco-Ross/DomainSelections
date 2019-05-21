package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Engine;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface EngineService extends ServiceGI<Engine, Integer> {
    ArrayList<Engine> getAllEngines();
}
