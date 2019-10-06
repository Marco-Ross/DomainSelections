package com.marco.service.transit.impl;

import com.marco.domain.transit.Engine;
import com.marco.repository.transit.transitrepo.EngineRepository;
import com.marco.service.transit.transitservice.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("EngineServiceImpl")
public class EngineServiceImpl implements EngineService {
    @Autowired
    private EngineRepository repository;

    @Override
    public ArrayList<Engine> getAllEngines() {
        return (ArrayList<Engine>) this.repository.findAll();
    }

    @Override
    public Engine create(Engine engine) {
        return this.repository.save(engine);
    }

    @Override
    public Engine update(Engine engine) {
        return this.repository.save(engine);
    }

    @Override
    public void delete(Integer engine) {
        this.repository.deleteById(engine);
    }

    @Override
    public Optional<Engine> read(Integer engine) {
        return this.repository.findById(engine);
    }
}
