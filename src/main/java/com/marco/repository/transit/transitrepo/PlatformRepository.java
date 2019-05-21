package com.marco.repository.transit.transitrepo;

import com.marco.domain.transit.Platform;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface PlatformRepository extends RepositoryGI<Platform, Integer> {
    Set<Platform> getAllPlatforms();
}
