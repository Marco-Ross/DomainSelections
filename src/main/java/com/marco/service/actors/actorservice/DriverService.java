package com.marco.service.actors.actorservice;

import com.marco.domain.actors.Driver;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface DriverService extends ServiceGI<Driver, Integer> {
    Set<Driver> getAllDrivers();
}
