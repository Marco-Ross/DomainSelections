package com.marco.repository.actors.impl;

import com.marco.domain.actors.DoorMan;
import com.marco.repository.actors.actorrepo.DoorManRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("DoorManRepoImpl")
public class DoorManRepositoryImpl implements DoorManRepository {
    private Map<Integer, DoorMan> doorMEN;

    private DoorManRepositoryImpl(){
        this.doorMEN = new HashMap<>();
    }

    @Override
    public Set<DoorMan> getAllDoorMen() {
        Collection<DoorMan> platforms = this.doorMEN.values();
        Set<DoorMan> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public DoorMan create(DoorMan doorMan) {
        this.doorMEN.put(doorMan.getEmployeeNumber(), doorMan);
        return this.doorMEN.get(doorMan.getEmployeeNumber());
    }

    @Override //account composed of loginDetail
    public DoorMan update(DoorMan doorMan) {
        this.doorMEN.replace(doorMan.getEmployeeNumber(), doorMan);
        return this.doorMEN.get(doorMan.getEmployeeNumber());
    }

    @Override
    public void delete(Integer empNumb) {
        this.doorMEN.remove(empNumb);
    }

    @Override
    public DoorMan read(Integer empNumb) {
        return this.doorMEN.get(empNumb);
    }
}
