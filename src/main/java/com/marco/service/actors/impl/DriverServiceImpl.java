package com.marco.service.actors.impl;

import com.marco.domain.actors.Driver;
import com.marco.repository.actors.actorrepo.DriverRepository;
import com.marco.repository.actors.impl.DriverRepositoryImpl;
import com.marco.service.actors.actorservice.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("DriverServiceImpl")
public class DriverServiceImpl implements DriverService {
    @Autowired
    @Qualifier("DriverRepoImpl")
    private DriverRepository repository;

    @Override
    public Set<Driver> getAllDrivers() {
        return this.repository.getAllDrivers();
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.create(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return this.repository.update(driver);
    }

    @Override
    public void delete(Integer driver) {
        this.repository.delete(driver);
    }

    @Override
    public Driver read(Integer driver) {
        return this.repository.read(driver);
    }
}
