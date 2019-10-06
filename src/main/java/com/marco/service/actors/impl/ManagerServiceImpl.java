package com.marco.service.actors.impl;

import com.marco.domain.actors.Manager;
import com.marco.repository.actors.actorrepo.ManagerRepository;
import com.marco.service.actors.actorservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository repository;

    @Override
    public ArrayList<Manager> getAllManagers() {
        return (ArrayList<Manager>) this.repository.findAll();
    }

    @Override
    public Manager create(Manager manager) {
        return this.repository.save(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return this.repository.save(manager);
    }

    @Override
    public void delete(Integer manager) {
        this.repository.deleteById(manager);
    }

    @Override
    public Optional<Manager> read(Integer manager) {
        return this.repository.findById(manager);
    }
}
