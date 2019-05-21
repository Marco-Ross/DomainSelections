package com.marco.service.actors.impl;

import com.marco.domain.actors.DoorMan;
import com.marco.repository.actors.actorrepo.DoorManRepository;
import com.marco.service.actors.actorservice.DoorManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("DoorManServiceImpl")
public class DoorManServiceImpl implements DoorManService {
    @Autowired
    @Qualifier("DoorManRepoImpl")
    private DoorManRepository repository;

    @Override
    public Set<DoorMan> getAllDoorMen() {
        return this.repository.getAllDoorMen();
    }

    @Override
    public DoorMan create(DoorMan doorMan) {
        return this.repository.create(doorMan);
    }

    @Override
    public DoorMan update(DoorMan doorMan) {
        return this.repository.update(doorMan);
    }

    @Override
    public void delete(Integer doorMan) {
        this.repository.delete(doorMan);
    }

    @Override
    public DoorMan read(Integer driver) {
        return this.repository.read(driver);
    }
}
