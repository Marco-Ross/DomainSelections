package com.marco.factory.transit;

import com.marco.domain.transit.Delay;
import com.marco.domain.transit.Station;
import org.junit.Test;

import static org.junit.Assert.*;

public class DelayFactoryTest {

    @Test
    public void getDelay() {
        int delayId = 15;
        String description = "man killed";

        Delay delay = DelayFactory.buildDelay(delayId, description);

        assertSame(delayId, delay.getDelayId());

    }
}