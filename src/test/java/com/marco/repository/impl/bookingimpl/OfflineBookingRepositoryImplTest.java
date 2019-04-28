package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.factory.bookings.OfflineBookingFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.OfflineBookingRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class OfflineBookingRepositoryImplTest {
    private OfflineBookingRepository repository;
    private OfflineBooking offlineBooking;
    private Date bookedDate;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        bookedDate = calendar.getTime();

        this.repository = OfflineBookingRepositoryImpl.getRepository();
        offlineBooking = OfflineBookingFactory.getOfflineBooking(12, bookedDate, 62);
        this.repository.create(offlineBooking);
    }

    @After
    public void tearDown() throws Exception {
        Set<OfflineBooking> set = repository.getAllOfflineBookings();
        set.clear();
    }

    @Test
    public void getAllOfflineBookings() {
        Set<OfflineBooking> set = repository.getAllOfflineBookings();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        OfflineBooking offlineBooking = OfflineBookingFactory.getOfflineBooking(15 , bookedDate, 20);
        OfflineBooking offlineBookingTest = this.repository.create(offlineBooking);

        Assert.assertEquals(offlineBooking, offlineBookingTest);
    }

    @Test
    public void update() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 8, 5);
        bookedDate = calendar.getTime();

        OfflineBooking offlineBooking = OfflineBookingFactory.getOfflineBooking(12, bookedDate, 30);

        Set<OfflineBooking> offlineBookings = repository.getAllOfflineBookings();
        Assert.assertTrue(offlineBookings.contains(offlineBooking));
        System.out.println("OfflineBooking updated");
    }

    @Test
    public void delete() {
        repository.delete(offlineBooking);
        Set<OfflineBooking> offlineBookings = repository.getAllOfflineBookings();
        Assert.assertEquals(0, offlineBookings.size());
    }

    @Test
    public void read() {
        OfflineBooking offlineBookingRead = repository.read(12);
        Assert.assertEquals(offlineBooking, offlineBookingRead);
    }
}