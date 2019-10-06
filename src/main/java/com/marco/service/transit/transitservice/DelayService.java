package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Delay;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public interface DelayService extends ServiceGI<Delay, Integer, Optional<Delay>> {
    Set<Delay> getAllDelays();
}
