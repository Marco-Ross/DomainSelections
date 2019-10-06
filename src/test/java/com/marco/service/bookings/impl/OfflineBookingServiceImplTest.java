package com.marco.service.bookings.impl;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.factory.bookings.OfflineBookingFactory;
import com.marco.service.bookings.bookingservice.OfflineBookingService;
import org.assertj.core.util.DateUtil;
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

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfflineBookingServiceImplTest {
    @Autowired
    @Qualifier("OfflineBookingServiceImpl")
    private OfflineBookingService service;
    private OfflineBooking offlineBooking;

    private OfflineBooking getRepo(){
        for(OfflineBooking offlineBookingA : service.getAllOfflineBookings()){
            if(offlineBookingA.getOfflineBookingID() == offlineBooking.getOfflineBookingID()){
                return offlineBookingA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        Date date = calendar.getTime();
        Date bookedDate = DateUtil.truncateTime(date);

        offlineBooking = OfflineBookingFactory.buildOfflineBooking(29, bookedDate, 62);
    }

    @Test
    public void d_getAllOfflineBookings() {
        Set<OfflineBooking> set = service.getAllOfflineBookings();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        OfflineBooking offlineBookingTest = this.service.create(offlineBooking);
        Assert.assertEquals(offlineBooking.getOfflineBookingID(), offlineBookingTest.getOfflineBookingID());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        OfflineBooking updated = new OfflineBooking.Builder().copy(getRepo()).offlineQuantityBooked(70).build();

        OfflineBooking offlineBooking = this.service.update(updated);

        Assert.assertSame(updated.getOfflineQuantityBooked(), offlineBooking.getOfflineQuantityBooked());
        System.out.println("OfflineBooking updated");
    }

    @Test
    public void e_delete() {
        service.delete(offlineBooking.getOfflineBookingID());
        Set<OfflineBooking> offlineBookings = service.getAllOfflineBookings();
        Assert.assertEquals(0, offlineBookings.size());
    }

    @Test
    public void b_read() {
        Optional<OfflineBooking> offlineBookingRead = service.read(offlineBooking.getOfflineBookingID());
        Assert.assertTrue(offlineBookingRead.isPresent());
        Assert.assertEquals(offlineBooking.getOfflineBookingDate(), offlineBookingRead.get().getOfflineBookingDate());
    }
}