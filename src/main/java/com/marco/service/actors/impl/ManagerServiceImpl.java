package com.marco.service.actors.impl;

import com.marco.domain.actors.Manager;
import com.marco.repository.actors.actorrepo.ManagerRepository;
import com.marco.repository.actors.impl.ManagerRepositoryImpl;
import com.marco.service.actors.actorservice.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    @Qualifier("ManagerRepoImpl")
    private ManagerRepository repository;

    @Override
    public ArrayList<Manager> getAllManagers() {
        return this.repository.getAllManagers();
    }

    @Override
    public Manager create(Manager manager) {
        return this.repository.create(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return this.repository.update(manager);
    }

    @Override
    public void delete(Integer manager) {
        this.repository.delete(manager);
    }

    @Override
    public Manager read(Integer manager) {
        return this.repository.read(manager);
    }
}
