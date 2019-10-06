package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Driver;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface DriverRepository extends CrudRepository<Driver, Integer> {
}
