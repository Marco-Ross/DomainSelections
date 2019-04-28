package com.marco.repository.impl.timingimpl;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.repositoryinterfaces.timingrepo.ScheduleRepository;
import javafx.scene.Scene;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class ScheduleRepositoryImplTest {
    private ScheduleRepository repository;
    private Schedule schedule;
    private Train train;
    private Date departureTime;
    private Date arrivalTime;

    @Before
    public void setUp() throws Exception {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(0, 0, 0,4,5,0);
        arrive.set(0,0,0,5,0,0);
        departureTime = depart.getTime();
        arrivalTime = arrive.getTime();

        train = TrainFactory.getTrain(2553, 145);

        this.repository = ScheduleRepositoryImpl.getRepository();
        schedule = ScheduleFactory.getSchedule(departureTime, arrivalTime, train);
        this.repository.create(schedule);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Schedule> arrayList = repository.getAllSchedules();
        arrayList.clear();
    }

    @Test
    public void getAllSchedules() {
        ArrayList<Schedule> arrayList = repository.getAllSchedules();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Schedule schedule = ScheduleFactory.getSchedule(departureTime, arrivalTime, train);
        Schedule scheduleTest = this.repository.create(schedule);

        Assert.assertEquals(schedule, scheduleTest);
    }

    @Test
    public void update() {
        Calendar depart = Calendar.getInstance();
        depart.set(0, 0, 0,4,30,0);
        departureTime = depart.getTime();

        Schedule schedule = ScheduleFactory.getSchedule(departureTime, arrivalTime, train);
        this.repository.update(schedule);

        ArrayList<Schedule> schedules = repository.getAllSchedules();
        Assert.assertTrue(schedules.contains(schedule));
        System.out.println("Schedule updated");
    }

    @Test
    public void delete() {
        repository.delete(schedule);
        ArrayList<Schedule> schedules = repository.getAllSchedules();
        Assert.assertEquals(0, schedules.size());
    }

    @Test
    public void read() {
        Schedule scheduleList = repository.read(schedule.getTrain());
        Assert.assertEquals(scheduleList, schedule);
    }
}