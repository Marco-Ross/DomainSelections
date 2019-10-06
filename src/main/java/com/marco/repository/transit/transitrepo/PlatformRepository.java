package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Platform;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PlatformRepository extends CrudRepository<Platform, Integer> {
}
