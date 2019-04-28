package com.marco.repository.impl.transitimpl;

import com.marco.domain.transit.Platform;
import com.marco.repository.repositoryinterfaces.transitrepo.PlatformRepository;

import java.util.HashSet;
import java.util.Set;

public class PlatformRepositoryImpl implements PlatformRepository {
    private static PlatformRepositoryImpl repository = null;
    private Set<Platform> platforms;

    private PlatformRepositoryImpl(){
        this.platforms = new HashSet<>();
    }

    public static PlatformRepositoryImpl getRepository(){
        if(repository == null) repository = new PlatformRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Platform> getAllPlatforms() {
        return this.platforms;
    }

    @Override
    public Platform create(Platform platform) {
        this.platforms.add(platform);
        return platform;
    }

    @Override
    public Platform update(Platform platform) {
        for(Platform platformA : platforms){
            if(platform.getPlatformNumber() == platformA.getPlatformNumber()){
                this.platforms.remove(platformA);
                this.platforms.add(platform);
            }
        }
        return platform;
    }

    @Override
    public void delete(Platform platform) {
        this.platforms.remove(platform);
    }

    @Override
    public Platform read(Integer platformNum) {
        Platform platform = null;
        for(Platform platformA : platforms){
            if(platformNum == platformA.getPlatformNumber()){
                platform = platformA;
            }
        }
        return platform;
    }
}
