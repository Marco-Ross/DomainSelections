package com.marco.repository.timings.timingrepo;

import com.marco.domain.timings.Schedule;
import com.marco.domain.transit.Train;
import com.marco.factory.timings.ScheduleFactory;
import com.marco.factory.transit.TrainFactory;
import com.marco.repository.timings.timingrepo.ScheduleRepository;
import com.marco.repository.timings.impl.ScheduleRepositoryImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScheduleRepositoryImplTest {
    @Autowired
    @Qualifier("ScheduleRepoImpl")
    private ScheduleRepository repository;
    private Schedule schedule;
    private Date departureTime;

    private Schedule getRepo(){
        for(Schedule scheduleA : repository.getAllSchedules()){
            if(scheduleA.getTrain().getTrainNumber() == schedule.getTrain().getTrainNumber()){
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

        Train train = TrainFactory.buildTrain(2553, 145, "Jesse");

        schedule = ScheduleFactory.buildSchedule(departureTime, arrivalTime, train);
    }

    @Test
    public void d_getAllSchedules() {
        ArrayList<Schedule> arrayList = repository.getAllSchedules();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Schedule scheduleTest = this.repository.create(schedule);

        Assert.assertEquals(schedule, scheduleTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        Calendar depart = Calendar.getInstance();
        depart.set(0, 0, 0,4,30,0);
        departureTime = depart.getTime();

        Schedule updated = new Schedule.Builder().copy(getRepo()).departure(departureTime).build();

        this.repository.update(updated);

        Assert.assertEquals(departureTime, updated.getDeparture());
        System.out.println("Schedule updated");
    }

    @Test
    public void e_delete() {
        repository.delete(schedule.getTrain().getTrainNumber());
        ArrayList<Schedule> schedules = repository.getAllSchedules();
        Assert.assertEquals(0, schedules.size());
    }

    @Test
    public void b_read() {
        Schedule scheduleRead = repository.read(schedule.getTrain().getTrainNumber());
        Assert.assertEquals(schedule.getTrain().getTrainNumber(), scheduleRead.getTrain().getTrainNumber());
    }
}