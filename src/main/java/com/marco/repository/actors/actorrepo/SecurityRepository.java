package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Security;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Set;

public interface SecurityRepository extends CrudRepository<Security, Integer> {
}
