package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.BookingStatus;
import com.marco.factory.bookings.BookingStatusFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.BookingStatusRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class BookingStatusRepositoryImplTest {
    private BookingStatusRepository repository;
    private BookingStatus bookingStatus;

    private Date bookedDate;

    @Before
    public void setUp() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 4, 31);
        bookedDate = calendar.getTime();

        this.repository = BookingStatusRepositoryImpl.getRepository();
        bookingStatus = BookingStatusFactory.getBookingStatus(553, bookedDate);
        this.repository.create(bookingStatus);
    }

    @After
    public void tearDown() throws Exception {
        Set<BookingStatus> set = repository.getAllBookingStatus();
        set.clear();
    }

    @Test
    public void getAllBookingStatus() {
        Set<BookingStatus> set = repository.getAllBookingStatus();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void create() {
        BookingStatus bookingStatus = BookingStatusFactory.getBookingStatus(220, bookedDate);
        BookingStatus bookingStatusTest = this.repository.create(bookingStatus);

        Assert.assertEquals(bookingStatus, bookingStatusTest);
    }

    @Test
    public void update() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 5, 6);
        bookedDate = calendar.getTime();

        BookingStatus bookingStatus = BookingStatusFactory.getBookingStatus(553, bookedDate);
        this.repository.update(bookingStatus);

        Set<BookingStatus> bookingStatuses = repository.getAllBookingStatus();
        Assert.assertTrue(bookingStatuses.contains(bookingStatus));
        System.out.println("BookingStatus updated");
    }

    @Test
    public void delete() {
        repository.delete(bookingStatus);
        Set<BookingStatus> bookingStatuses = repository.getAllBookingStatus();
        Assert.assertEquals(0, bookingStatuses.size());
    }

    @Test
    public void read() {
        BookingStatus bookingStatusRead = repository.read(553);
        Assert.assertEquals(bookingStatus, bookingStatusRead);
    }
}