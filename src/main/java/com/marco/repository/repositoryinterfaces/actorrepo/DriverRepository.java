package com.marco.repository.repositoryinterfaces.actorrepo;

import com.marco.domain.actors.Driver;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface DriverRepository extends RepositoryGI<Driver, Integer> {
    Set<Driver> getAllDrivers();
}
