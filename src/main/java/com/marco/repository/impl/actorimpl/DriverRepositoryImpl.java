package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Driver;
import com.marco.repository.repositoryinterfaces.actorrepo.DriverRepository;

import java.util.HashSet;
import java.util.Set;

public class DriverRepositoryImpl implements DriverRepository {
    private static DriverRepositoryImpl repository = null;
    private Set<Driver> drivers;

    private DriverRepositoryImpl(){
        this.drivers = new HashSet<>();
    }

    public static DriverRepositoryImpl getRepository(){
        if(repository == null) repository = new DriverRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Driver> getAllDrivers() {
        return this.drivers;
    }

    @Override
    public Driver create(Driver driver) {
        this.drivers.add(driver);
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        for(Driver driverA : drivers){
            if(driver.getEmployeeNumber() == driverA.getEmployeeNumber()){
                this.drivers.remove(driverA);
                this.drivers.add(driver);
            }
        }
        return driver;
    }

    @Override
    public void delete(Driver driver) {
        this.drivers.remove(driver);
    }

    @Override
    public Driver read(Integer empNumb) {
        Driver driver = null;
        for(Driver driverA : drivers){
            if(empNumb == driverA.getEmployeeNumber()){
                driver = driverA;
            }
        }
        return driver;
    }
}
