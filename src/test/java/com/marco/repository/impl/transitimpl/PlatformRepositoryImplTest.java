package com.marco.repository.impl.transitimpl;



import com.marco.domain.transit.Platform;
import com.marco.factory.transit.PlatformFactory;
import com.marco.repository.repositoryinterfaces.transitrepo.PlatformRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PlatformRepositoryImplTest {
    private PlatformRepository repository;
    private Platform platform;

    @Before
    public void setUp() throws Exception {
        this.repository = PlatformRepositoryImpl.getRepository();
        platform = PlatformFactory.getPlatform(10, 12);
        this.repository.create(platform);
    }

    @After
    public void tearDown() throws Exception {
        Set<Platform> set = repository.getAllPlatforms();
        set.clear();
    }

    @Test
    public void getAllPlatforms() {
        Set<Platform> set = repository.getAllPlatforms();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        Platform platform = PlatformFactory.getPlatform(4, 30);
        Platform platformTest = this.repository.create(platform);

        Assert.assertEquals(platform, platformTest);
    }

    @Test
    public void update() {
        Platform platform = PlatformFactory.getPlatform(10, 35);
        this.repository.update(platform);

        Set<Platform> platforms = repository.getAllPlatforms();
        Assert.assertTrue(platforms.contains(platform));
        System.out.println("Platforms updated");
    }

    @Test
    public void delete() {
        repository.delete(platform);
        Set<Platform> platforms = repository.getAllPlatforms();
        Assert.assertEquals(0, platforms.size());
    }

    @Test
    public void read() {
        Platform platformRead = repository.read(10);
        Assert.assertEquals(platform, platformRead);
    }
}