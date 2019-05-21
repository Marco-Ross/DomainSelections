package com.marco.service.transit.impl;

import com.marco.domain.transit.Carriage;
import com.marco.repository.transit.impl.CarriageRepositoryImpl;
import com.marco.repository.transit.transitrepo.CarriageRepository;
import com.marco.service.transit.transitservice.CarriageService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("CarriageServiceImpl")
public class CarriageServiceImpl implements CarriageService {
    @Autowired
    @Qualifier("CarriageRepoImpl")
    private CarriageRepository repository;

    @Override
    public Set<Carriage> getAllCarriages() {
        return this.repository.getAllCarriages();
    }

    @Override
    public Carriage create(Carriage carriage) {
        return this.repository.create(carriage);
    }

    @Override
    public Carriage update(Carriage carriage) {
        return this.repository.update(carriage);
    }

    @Override
    public void delete(Integer carriage) {
        this.repository.delete(carriage);
    }

    @Override
    public Carriage read(Integer carriage) {
        return this.repository.read(carriage);
    }
}
