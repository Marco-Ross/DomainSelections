package com.marco.repository.repositoryinterfaces.transitrepo;

import com.marco.domain.transit.Platform;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface PlatformRepository extends RepositoryGI<Platform, Integer> {
    Set<Platform> getAllPlatforms();
}
