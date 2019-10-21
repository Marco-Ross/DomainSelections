package com.marco.service.actors.impl;

import com.google.common.collect.Sets;
import com.marco.domain.actors.Driver;
import com.marco.repository.actors.actorrepo.DriverRepository;
import com.marco.service.actors.actorservice.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("DriverServiceImpl")
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository repository;

    @Override
    public Set<Driver> getAllDrivers() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public void delete(Integer driver) {
        this.repository.deleteById(driver);
    }

    @Override
    public Optional<Driver> read(Integer driver) {
        return this.repository.findById(driver);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
