package com.marco.service.bookings.impl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.factory.bookings.OnlineBookingFactory;
import com.marco.service.bookings.bookingservice.OnlineBookingService;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OnlineBookingServiceImplTest {
    @Autowired
    @Qualifier("OnlineBookingServiceImpl")
    private OnlineBookingService service;
    private OnlineBooking onlineBooking;
    private Date bookedDate;

    private OnlineBooking getRepo(){
        for(OnlineBooking onlineBookingA : service.getAllOnlineBookings()){
            if(onlineBookingA.getOnlineBookingId() == onlineBooking.getOnlineBookingId()){
                return onlineBookingA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        bookedDate = calendar.getTime();

        onlineBooking = OnlineBookingFactory.buildOnlineBooking(13, bookedDate,5);
    }

    @Test
    public void d_getAllOnlineBookings() {
        ArrayList<OnlineBooking> arrayList = service.getAllOnlineBookings();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        OnlineBooking onlineBookingTest = this.service.create(onlineBooking);
        Assert.assertEquals(onlineBooking, onlineBookingTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 6, 12);
        bookedDate = calendar.getTime();

        OnlineBooking updated = new OnlineBooking.Builder().copy(getRepo()).onlineBookingDate(bookedDate).build();

        this.service.update(updated);

        Assert.assertSame(bookedDate, updated.getOnlineBookingDate());
        System.out.println("OnlineBooking updated");
    }

    @Test
    public void e_delete() {
        service.delete(onlineBooking.getOnlineBookingId());
        ArrayList<OnlineBooking> onlineBookings = service.getAllOnlineBookings();
        Assert.assertEquals(0, onlineBookings.size());
    }

    @Test
    public void b_read() {
        OnlineBooking onlineBookingRead = service.read(13);
        Assert.assertSame(onlineBooking.getOnlineBookingId(), onlineBookingRead.getOnlineBookingId());
    }
}