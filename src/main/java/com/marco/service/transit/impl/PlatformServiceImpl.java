package com.marco.service.transit.impl;

import com.google.common.collect.Sets;
import com.marco.domain.transit.Platform;
import com.marco.repository.transit.transitrepo.PlatformRepository;
import com.marco.service.transit.transitservice.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("PlatformServiceImpl")
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private PlatformRepository repository;

    @Override
    public Set<Platform> getAllPlatforms() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public Platform create(Platform platform) {
        return this.repository.save(platform);
    }

    @Override
    public Platform update(Platform platform) {
        return this.repository.save(platform);
    }

    @Override
    public void delete(Integer platform) {
        this.repository.deleteById(platform);
    }

    @Override
    public Optional<Platform> read(Integer platform) {
        return this.repository.findById(platform);
    }
}
