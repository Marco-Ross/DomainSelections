package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.DoorMan;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface DoorManRepository extends CrudRepository<DoorMan, Integer> {
}
