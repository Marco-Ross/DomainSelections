package com.marco.service.transit.impl;

import com.marco.domain.transit.Platform;
import com.marco.factory.transit.PlatformFactory;
import com.marco.service.transit.transitservice.PlatformService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlatformServiceImplTest {
    @Autowired
    @Qualifier("PlatformServiceImpl")
    private PlatformService service;
    private Platform platform;

    private Platform getRepo(){
        for(Platform platformA : service.getAllPlatforms()){
            if(platformA.getPlatformNumber() == platform.getPlatformNumber()){
                return platformA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        platform = PlatformFactory.buildPlatform(10, 12);
    }

    @Test
    public void d_getAllPlatforms() {
        Set<Platform> set = service.getAllPlatforms();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        Platform platformTest = this.service.create(platform);
        Assert.assertEquals(platform, platformTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        int platformLength = 5;
        Platform updated = new Platform.Builder().copy(getRepo()).platformLength(platformLength).build();

        this.service.update(updated);

        Assert.assertEquals(platformLength, updated.getPlatformLength());
        System.out.println("Platform updated");
    }

    @Test
    public void e_delete() {
        service.delete(platform.getPlatformNumber());
        Set<Platform> platforms = service.getAllPlatforms();
        Assert.assertEquals(0, platforms.size());
    }

    @Test
    public void b_read() {
        Platform platformRead = service.read(10);
        Assert.assertEquals(platform.getPlatformNumber(), platformRead.getPlatformNumber());
    }
}