package com.marco.service.transit.transitservice;

import com.marco.domain.transit.Platform;
import com.marco.service.ServiceGI;

import java.util.Set;

public interface PlatformService extends ServiceGI<Platform, Integer> {
    Set<Platform> getAllPlatforms();
}
