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

import java.text.Format;
import java.text.SimpleDateFormat;
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
            if(scheduleA.getScheduleID().equals(schedule.getScheduleID())){
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

        if(repository.getAllSchedules().size() == 0){ schedule = ScheduleFactory.buildSchedule(departureString, arrivalString);}
        else{schedule = repository.getAllSchedules().get(0);}
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

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String departureString = formatter.format(departureTime);

        Schedule updated = this.repository.update(new Schedule.Builder().copy(getRepo()).departure(departureString).build());

        Assert.assertEquals(departureString, updated.getDeparture());
        System.out.println("Schedule updated");
    }

    @Test
    public void e_delete() {
        repository.delete(schedule.getScheduleID());
        ArrayList<Schedule> schedules = repository.getAllSchedules();
        Assert.assertEquals(0, schedules.size());
    }

    @Test
    public void b_read() {
        Schedule scheduleRead = repository.read(schedule.getScheduleID());
        Assert.assertEquals(schedule.getScheduleID(), scheduleRead.getScheduleID());
    }
}