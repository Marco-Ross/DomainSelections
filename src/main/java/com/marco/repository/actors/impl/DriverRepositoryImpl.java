//package com.marco.repository.actors.impl;
//
//import com.marco.domain.actors.Driver;
//import com.marco.repository.actors.actorrepo.DriverRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("DriverRepoImpl")
//public class DriverRepositoryImpl implements DriverRepository {
//    private Set<Driver> drivers;
//
//    private DriverRepositoryImpl(){
//        this.drivers = new HashSet<>();
//    }
//
//    @Override
//    public Set<Driver> getAllDrivers() {
//        return this.drivers;
//    }
//
//    @Override
//    public Driver create(Driver driver) {
//        this.drivers.add(driver);
//        for(Driver driverA : drivers){
//            if(driver == driverA){
//                return driverA;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Driver update(Driver driver) {
//        for(Driver driverA : drivers){
//            if(driver.getEmployeeNumber() == driverA.getEmployeeNumber()){
//                this.drivers.remove(driverA);
//                this.drivers.add(driver);
//                return driver;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Integer empNumb) {
//        for(Driver driverA : drivers){
//            if(empNumb == driverA.getEmployeeNumber()){
//                this.drivers.remove(driverA);
//            }
//        }
//    }
//
//    @Override
//    public Driver read(Integer empNumb) {
//        for(Driver driverA : drivers){
//            if(empNumb == driverA.getEmployeeNumber()){
//                return driverA;
//            }
//        }
//        return null;
//    }
//}
