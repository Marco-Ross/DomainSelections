package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Carriage;
import com.marco.repository.repositoryinterfaces.transitrepo.CarriageRepository;

import java.util.HashSet;
import java.util.Set;

public class CarriageRepositoryImpl implements CarriageRepository {

    private static CarriageRepositoryImpl repository = null;
    private Set<Carriage> carriages;

    private CarriageRepositoryImpl(){
        this.carriages = new HashSet<>();
    }

    public static CarriageRepositoryImpl getRepository(){
        if(repository == null) repository = new CarriageRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Carriage> getAllCarriages() {
        return this.carriages;
    }

    @Override
    public Carriage create(Carriage carriage) {
        this.carriages.add(carriage);
        return carriage;
    }

    @Override
    public Carriage update(Carriage carriage) {
        for(Carriage carriageA : carriages){
            if(carriage.getCarriageNumber() == (carriageA.getCarriageNumber())){
                this.carriages.remove(carriageA);
                this.carriages.add(carriage);
            }
        }
        return carriage;
    }

    @Override
    public void delete(Carriage carriage) {
        this.carriages.remove(carriage);
    }

    @Override
    public Carriage read(Integer carriage) {
        Carriage carriage1 = null;
        for(Carriage carriageA : carriages){
            if(carriage.equals(carriageA.getCarriageNumber())){
                carriage1 = carriageA;
            }
        }
        return carriage1;
    }
}
