package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Platform;
import com.marco.service.ServiceGI;

import java.util.Optional;
import java.util.Set;

public interface PlatformService extends ServiceGI<Platform, Integer, Optional<Platform>> {
    Set<Platform> getAllPlatforms();
}
