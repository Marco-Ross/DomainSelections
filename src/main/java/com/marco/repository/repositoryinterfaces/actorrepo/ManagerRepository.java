package com.marco.repository.repositoryinterfaces.actorrepo;

import com.marco.domain.actors.Manager;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface ManagerRepository extends RepositoryGI<Manager, Integer> {
    ArrayList<Manager> getAllManagers();
}
