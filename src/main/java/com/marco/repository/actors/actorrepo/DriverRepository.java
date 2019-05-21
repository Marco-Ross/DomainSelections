package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Driver;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface DriverRepository extends RepositoryGI<Driver, Integer> {
    Set<Driver> getAllDrivers();
}
