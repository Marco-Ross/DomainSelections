package com.marco.factory.timings;

import com.marco.domain.timings.Schedule;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ScheduleFactoryTest {

    @Test
    public void getSchedule() {
        String trainLocation = "Maitland";
        Date trainDelays = new Date();
        Schedule schedule = ScheduleFactory.getSchedule(trainLocation, trainDelays);
        assertNotNull(schedule.getTrainLocation());
    }
}