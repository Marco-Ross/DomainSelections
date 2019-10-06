package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Carriage;
import com.marco.repository.transit.transitrepo.CarriageRepository;
import com.marco.service.transit.transitservice.CarriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("CarriageServiceImpl")
public class CarriageServiceImpl implements CarriageService {
    @Autowired
    private CarriageRepository repository;

    @Override
    public Set<Carriage> getAllCarriages() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Carriage create(Carriage carriage) {
        return this.repository.save(carriage);
    }

    @Override
    public Carriage update(Carriage carriage) {
        return this.repository.save(carriage);
    }

    @Override
    public void delete(Integer carriage) {
        this.repository.deleteById(carriage);
    }

    @Override
    public Optional<Carriage> read(Integer carriage) {
        return this.repository.findById(carriage);
    }
}
