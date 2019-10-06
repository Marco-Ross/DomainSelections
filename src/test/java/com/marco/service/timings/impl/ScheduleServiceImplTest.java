package com.marco.service.timings.impl;

import com.marco.domain.timings.Schedule;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.service.timings.timingservice.ScheduleService;
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

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleServiceImplTest {
    @Autowired
    @Qualifier("ScheduleServiceImpl")
    private ScheduleService service;
    private Schedule schedule;
    private Date departureTime;

    private Schedule getRepo(){
        for(Schedule scheduleA : service.getAllSchedules()){
            if(scheduleA.getScheduleID() == schedule.getScheduleID()){
                return scheduleA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Calendar depart = Calendar.getInstance();
        Calendar arrive = Calendar.getInstance();
        depart.set(0, 0, 0,4,5,0);
        arrive.set(0,0,0,5,0,0);
        departureTime = depart.getTime();
        Date arrivalTime = arrive.getTime();

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String departureString = formatter.format(departureTime);
        String arrivalString = formatter.format(arrivalTime);

        if(service.getAllSchedules().size() == 0){ schedule = ScheduleFactory.buildSchedule(departureString, arrivalString);}
        else{schedule = service.getAllSchedules().get(0);}
    }

    @Test
    public void d_getAllSchedules() {
        ArrayList<Schedule> arrayList = service.getAllSchedules();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Schedule scheduleTest = this.service.create(schedule);

        Assert.assertEquals(schedule, scheduleTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        Calendar depart = Calendar.getInstance();
        depart.set(0, 0, 0,4,30,0);
        departureTime = depart.getTime();

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String departureString = formatter.format(departureTime);

        Schedule updated = new Schedule.Builder().copy(getRepo()).departure(departureString).build();

        this.service.update(updated);

        Assert.assertEquals(departureString, updated.getDeparture());
        System.out.println("Schedule updated");
    }

    @Test
    public void e_delete() {
        service.delete(schedule.getScheduleID());
        ArrayList<Schedule> schedules = service.getAllSchedules();
        Assert.assertEquals(0, schedules.size());
    }

    @Test
    public void b_read() {
        Optional<Schedule> scheduleRead = service.read(schedule.getScheduleID());
        Assert.assertTrue(scheduleRead.isPresent());
        Assert.assertEquals(schedule.getScheduleID(), scheduleRead.get().getScheduleID());
    }
}