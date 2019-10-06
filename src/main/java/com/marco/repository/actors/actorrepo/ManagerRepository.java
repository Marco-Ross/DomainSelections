package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Manager;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
}
