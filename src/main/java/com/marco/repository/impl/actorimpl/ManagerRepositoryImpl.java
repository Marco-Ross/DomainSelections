package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.Manager;
import com.marco.repository.repositoryinterfaces.actorrepo.ManagerRepository;

import java.util.ArrayList;

public class ManagerRepositoryImpl implements ManagerRepository {
    private static ManagerRepositoryImpl repository = null;
    private ArrayList<Manager> managers;

    private ManagerRepositoryImpl(){
        this.managers = new ArrayList<>();
    }

    public static ManagerRepositoryImpl getRepository(){
        if(repository == null) repository = new ManagerRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Manager> getAllManagers() {
        return this.managers;
    }

    @Override
    public Manager create(Manager manager) {
        this.managers.add(manager);
        return manager;
    }

    @Override
    public Manager update(Manager manager) {
        for(int i = 0; i<managers.size();i++){
            if(manager.getEmployeeNumber() == managers.get(i).getEmployeeNumber()){
                this.managers.set(i, manager);
            }
        }
        return manager;
    }

    @Override
    public void delete(Manager manager) {
        this.managers.remove(manager);
    }

    @Override
    public Manager read(Integer empNumb) {
        Manager manager = null;
        for(Manager managerA : managers){
            if(empNumb == managerA.getEmployeeNumber()){
                manager = managerA;
            }
        }
        return manager;
    }
}
