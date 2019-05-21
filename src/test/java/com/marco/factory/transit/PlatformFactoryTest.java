package com.marco.factory.transit;

import com.marco.domain.transit.Platform;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PlatformFactoryTest {

    @Test
    public void getPlatform() {
        int platformNumber = 3;

        Platform platform = PlatformFactory.buildPlatform(platformNumber, 40);
        assertSame(platformNumber, platform.getPlatformNumber());
    }
}