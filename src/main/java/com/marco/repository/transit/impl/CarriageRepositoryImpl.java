package com.marco.repository.transit.impl;

import com.marco.domain.transit.Carriage;
import com.marco.repository.transit.transitrepo.CarriageRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("CarriageRepoImpl")
public class CarriageRepositoryImpl implements CarriageRepository {
    private Set<Carriage> carriages;

    private CarriageRepositoryImpl(){
        this.carriages = new HashSet<>();
    }

    @Override
    public Set<Carriage> getAllCarriages() {
        return this.carriages;
    }

    @Override
    public Carriage create(Carriage carriage) {
        this.carriages.add(carriage);
        for(Carriage carriageA : carriages){
            if(carriage.equals(carriageA)){
                return carriageA;
            }
        }
        return null;
    }

    @Override
    public Carriage update(Carriage carriage) {
        for(Carriage carriageA : carriages){
            if(carriage.getCarriageNumber() == (carriageA.getCarriageNumber())){
                this.carriages.remove(carriageA);
                this.carriages.add(carriage);
                return carriage;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer carriage) {
        for(Carriage carriageA : carriages){
            if(carriage.equals(carriageA.getCarriageNumber())){
                this.carriages.remove(carriageA);
            }
        }
    }

    @Override
    public Carriage read(Integer carriage) {
        for(Carriage carriageA : carriages){
            if(carriage.equals(carriageA.getCarriageNumber())){
                return carriageA;
            }
        }
        return null;
    }
}
