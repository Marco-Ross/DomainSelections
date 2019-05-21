package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.DoorMan;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface DoorManRepository extends RepositoryGI<DoorMan, Integer> {
    Set<DoorMan> getAllDoorMen();
}
