package com.marco.repository.actors.impl;

import com.marco.domain.actors.Manager;
import com.marco.repository.actors.actorrepo.ManagerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("ManagerRepoImpl")
public class ManagerRepositoryImpl implements ManagerRepository {
    private ArrayList<Manager> managers;

    private ManagerRepositoryImpl(){
        this.managers = new ArrayList<>();
    }

    @Override
    public ArrayList<Manager> getAllManagers() {
        return this.managers;
    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        for(Manager managerA : managers){
            if(manager == managerA){
                return managerA;
            }
        }
        return null;
    }

    @Override
    public Manager update(Manager manager) {
        for(int i = 0; i<managers.size();i++){
            if(manager.getEmployeeNumber() == managers.get(i).getEmployeeNumber()){
                this.managers.set(i, manager);
                return manager;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer empNumb) {
        for(Manager managerA : managers){
            if(empNumb == managerA.getEmployeeNumber()){
                this.managers.remove(managerA);
                break;
            }
        }
    }

    @Override
    public Manager read(Integer empNumb) {
        for(Manager managerA : managers){
            if(empNumb == managerA.getEmployeeNumber()){
                return managerA;
            }
        }
        return null;
    }
}
