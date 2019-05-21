package com.marco.repository.transit.impl;

import com.marco.domain.transit.Platform;
import com.marco.repository.transit.transitrepo.PlatformRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("PlatformRepoImpl")
public class PlatformRepositoryImpl implements PlatformRepository {
    private Map<Integer, Platform> platforms;

    private PlatformRepositoryImpl(){
        this.platforms = new HashMap<>();
    }

    @Override
    public Set<Platform> getAllPlatforms() {
        Collection<Platform> platforms = this.platforms.values();
        Set<Platform> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public Platform create(Platform platform) {
        this.platforms.put(platform.getPlatformNumber(), platform);
        return this.platforms.get(platform.getPlatformNumber());
    }

    @Override
    public Platform update(Platform platform) {
        this.platforms.replace(platform.getPlatformNumber(), platform);
        return this.platforms.get(platform.getPlatformNumber());
    }

    @Override
    public void delete(Integer platformNum) {
        this.platforms.remove(platformNum);
    }

    @Override
    public Platform read(Integer platformNum) {
        return this.platforms.get(platformNum);
    }
}
