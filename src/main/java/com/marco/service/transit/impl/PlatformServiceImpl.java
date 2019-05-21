package com.marco.service.transit.impl;

import com.marco.domain.transit.Platform;
import com.marco.repository.transit.impl.PlatformRepositoryImpl;
import com.marco.repository.transit.transitrepo.PlatformRepository;
import com.marco.service.transit.transitservice.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("PlatformServiceImpl")
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    @Qualifier("PlatformRepoImpl")
    private PlatformRepository repository;

    @Override
    public Set<Platform> getAllPlatforms() {
        return this.repository.getAllPlatforms();
    }

    @Override
    public Platform create(Platform platform) {
        return this.repository.create(platform);
    }

    @Override
    public Platform update(Platform platform) {
        return this.repository.update(platform);
    }

    @Override
    public void delete(Integer platform) {
        this.repository.delete(platform);
    }

    @Override
    public Platform read(Integer platform) {
        return this.repository.read(platform);
    }
}
