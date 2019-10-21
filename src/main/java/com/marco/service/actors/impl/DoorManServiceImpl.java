package com.marco.service.actors.impl;

import com.google.common.collect.Sets;
import com.marco.domain.actors.DoorMan;
import com.marco.repository.actors.actorrepo.DoorManRepository;
import com.marco.service.actors.actorservice.DoorManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("DoorManServiceImpl")
public class DoorManServiceImpl implements DoorManService {
    @Autowired
    private DoorManRepository repository;

    @Override
    public Set<DoorMan> getAllDoorMen() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public DoorMan create(DoorMan doorMan) {
        return this.repository.save(doorMan);
    }

    @Override
    public DoorMan update(DoorMan doorMan) {
        return this.repository.save(doorMan);
    }

    @Override
    public void delete(Integer doorMan) {
        this.repository.deleteById(doorMan);
    }

    @Override
    public Optional<DoorMan> read(Integer driver) {
        return this.repository.findById(driver);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
