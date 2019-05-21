package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Manager;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface ManagerRepository extends RepositoryGI<Manager, Integer> {
    ArrayList<Manager> getAllManagers();
}
