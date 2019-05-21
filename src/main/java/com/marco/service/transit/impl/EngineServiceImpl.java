package com.marco.service.transit.impl;

import com.marco.domain.transit.Engine;
import com.marco.repository.transit.impl.EngineRepositoryImpl;
import com.marco.repository.transit.transitrepo.EngineRepository;
import com.marco.service.transit.transitservice.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("EngineServiceImpl")
public class EngineServiceImpl implements EngineService {
    @Autowired
    @Qualifier("EngineRepoImpl")
    private EngineRepository repository;

    @Override
    public ArrayList<Engine> getAllEngines() {
        return this.repository.getAllEngines();
    }

    @Override
    public Engine create(Engine engine) {
        return this.repository.create(engine);
    }

    @Override
    public Engine update(Engine engine) {
        return this.repository.update(engine);
    }

    @Override
    public void delete(Integer engine) {
        this.repository.delete(engine);
    }

    @Override
    public Engine read(Integer engine) {
        return this.repository.read(engine);
    }
}
