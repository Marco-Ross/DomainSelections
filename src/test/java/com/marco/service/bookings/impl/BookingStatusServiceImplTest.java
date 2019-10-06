package com.marco.service.bookings.impl;

import com.marco.domain.bookings.BookingStatus;
import com.marco.factory.bookings.BookingStatusFactory;
import com.marco.service.bookings.bookingservice.BookingStatusService;
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
public class BookingStatusServiceImplTest {
    @Autowired
    @Qualifier("BookingStatusServiceImpl")
    private BookingStatusService service;
    private BookingStatus bookingStatus;

    private Date bookedDate;

    private BookingStatus getRepo(){
        for(BookingStatus bookingStatusA : service.getAllBookingStatus()){
            if(bookingStatusA.getBookingId() == bookingStatus.getBookingId()){
                return bookingStatusA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        bookedDate = calendar.getTime();

        bookingStatus = BookingStatusFactory.buildBookingStatus(553, bookedDate);
    }

    @Test
    public void d_getAllBookingStatus() {
        Set<BookingStatus> set = service.getAllBookingStatus();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        BookingStatus bookingStatusTest = this.service.create(bookingStatus);
        Assert.assertEquals(bookingStatus.getBookingId(), bookingStatusTest.getBookingId());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 6);
        bookedDate = calendar.getTime();

        BookingStatus updated = new BookingStatus.Builder().copy(getRepo()).timesBooked(bookedDate).build();

        this.service.update(updated);

        Assert.assertSame(bookedDate, updated.getTimesBooked());
        System.out.println("BookingStatus updated");
    }

    @Test
    public void e_delete() {
        service.delete(bookingStatus.getBookingId());
        Set<BookingStatus> bookingStatuses = service.getAllBookingStatus();
        Assert.assertEquals(0, bookingStatuses.size());
    }

    @Test
    public void b_read() {
        Optional<BookingStatus> bookingStatusRead = service.read(553);
        Assert.assertTrue(bookingStatusRead.isPresent());
        Assert.assertEquals(bookingStatus.getBookingId(), bookingStatusRead.get().getBookingId(), 0.1);
    }
}