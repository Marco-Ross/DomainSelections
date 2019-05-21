package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.factory.bookings.OfflineBookingFactory;
import com.marco.repository.bookings.impl.OfflineBookingRepositoryImpl;
import com.marco.repository.bookings.bookingrepo.OfflineBookingRepository;
import org.assertj.core.util.DateUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfflineBookingRepositoryImplTest {
    @Autowired
    @Qualifier("OfflineBookingRepoImpl")
    private OfflineBookingRepository repository;
    private OfflineBooking offlineBooking;

    private OfflineBooking getRepo(){
       for(OfflineBooking offlineBookingA : repository.getAllOfflineBookings()){
            if(offlineBookingA.getOfflineBookingDate().equals(offlineBooking.getOfflineBookingDate())){
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

        offlineBooking = OfflineBookingFactory.buildOfflineBooking(bookedDate, 62);
    }

    @Test
    public void d_getAllOfflineBookings() {
        Set<OfflineBooking> set = repository.getAllOfflineBookings();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        OfflineBooking offlineBookingTest = this.repository.create(offlineBooking);
        Assert.assertEquals(offlineBooking, offlineBookingTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
         OfflineBooking updated = new OfflineBooking.Builder().copy(getRepo()).offlineQuantityBooked(70).build();

        OfflineBooking offlineBooking = this.repository.update(updated);

        Assert.assertSame(updated.getOfflineQuantityBooked(), offlineBooking.getOfflineQuantityBooked());
        System.out.println("OfflineBooking updated");
    }

    @Test
    public void e_delete() {
        repository.delete(offlineBooking.getOfflineBookingDate());
        Set<OfflineBooking> offlineBookings = repository.getAllOfflineBookings();
        Assert.assertEquals(0, offlineBookings.size());
    }

    @Test
    public void b_read() {
        OfflineBooking offlineBookingRead = repository.read(offlineBooking.getOfflineBookingDate());
        Assert.assertEquals(offlineBooking.getOfflineBookingDate(), offlineBookingRead.getOfflineBookingDate());
    }
}