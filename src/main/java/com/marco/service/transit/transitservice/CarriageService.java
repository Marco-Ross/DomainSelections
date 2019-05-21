package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Carriage;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface CarriageService extends ServiceGI<Carriage, Integer> {
    Set<Carriage> getAllCarriages();
}
