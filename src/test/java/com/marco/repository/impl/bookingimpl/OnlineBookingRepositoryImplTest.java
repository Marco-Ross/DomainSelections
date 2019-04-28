package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.factory.bookings.OnlineBookingFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.OnlineBookingRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class OnlineBookingRepositoryImplTest {
    private OnlineBookingRepository repository;
    private OnlineBooking onlineBooking;
    private Date bookedDate;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        bookedDate = calendar.getTime();

        this.repository = OnlineBookingRepositoryImpl.getRepository();
        onlineBooking = OnlineBookingFactory.getOnlineBooking(13, bookedDate,5); //payment can be added here
        this.repository.create(onlineBooking);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<OnlineBooking> arrayList = repository.getAllOnlineBookings();
        arrayList.clear();
    }

    @Test
    public void getAllOnlineBookings() {
        ArrayList<OnlineBooking> arrayList = repository.getAllOnlineBookings();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        OnlineBooking onlineBooking = OnlineBookingFactory.getOnlineBooking(15, bookedDate, 3);
        OnlineBooking onlineBookingTest = this.repository.create(onlineBooking);

        Assert.assertEquals(onlineBooking, onlineBookingTest);
    }

    @Test
    public void update() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 6, 12);
        bookedDate = calendar.getTime();

        OnlineBooking onlineBooking = OnlineBookingFactory.getOnlineBooking(12, bookedDate, 5);
        this.repository.update(onlineBooking);

        ArrayList<OnlineBooking> onlineBookings = repository.getAllOnlineBookings();
        Assert.assertTrue(onlineBookings.contains(onlineBooking));
        System.out.println("OnlineBooking updated");
    }

    @Test
    public void delete() {
        repository.delete(onlineBooking);
        ArrayList<OnlineBooking> onlineBookings = repository.getAllOnlineBookings();
        Assert.assertEquals(0, onlineBookings.size());
    }

    @Test
    public void read() {
        OnlineBooking onlineBookingRead = repository.read(13);
        Assert.assertEquals(onlineBooking, onlineBookingRead);
    }
}