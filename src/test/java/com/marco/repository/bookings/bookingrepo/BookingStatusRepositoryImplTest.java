//package com.marco.repository.bookings.bookingrepo;
//
//import com.marco.domain.bookings.BookingStatus;
//import com.marco.factory.bookings.BookingStatusFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class BookingStatusRepositoryImplTest {
//    @Autowired
//    private BookingStatusRepository repository;
//    private BookingStatus bookingStatus;
//
//    private Date bookedDate;
//
//    private BookingStatus getRepo(){
//       for(BookingStatus bookingStatusA : repository.findAll()){
//            if(bookingStatusA.getBookingId() == bookingStatus.getBookingId()){
//                return bookingStatusA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 4, 31, 0,0,0);
//        bookedDate = calendar.getTime();
//
//        bookingStatus = BookingStatusFactory.buildBookingStatus(553, bookedDate);
//    }
//
//    @Test
//    public void d_getAllBookingStatus() {
//        Set<BookingStatus> set = (Set<BookingStatus>) repository.findAll();
//        Assert.assertEquals(1, set.size());
//    }
//
//    @Test
//    public void a_create() {
//        BookingStatus bookingStatusTest = this.repository.save(bookingStatus);
//        Assert.assertSame(bookingStatus, bookingStatusTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 5, 6, 0,0,0);
//        bookedDate = calendar.getTime();
//
//        BookingStatus updated = new BookingStatus.Builder().copy(getRepo()).timesBooked(bookedDate).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(bookedDate, updated.getTimesBooked());
//        System.out.println("BookingStatus updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(bookingStatus.getBookingId());
//        Set<BookingStatus> bookingStatuses = (Set<BookingStatus>) repository.findAll();
//        Assert.assertEquals(0, bookingStatuses.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<BookingStatus> bookingStatusRead = repository.findById(553);
//        Assert.assertTrue(bookingStatusRead.isPresent());
//        Assert.assertEquals(bookingStatus.getBookingId(), bookingStatusRead.get().getBookingId(), 0.1);
//    }
//}