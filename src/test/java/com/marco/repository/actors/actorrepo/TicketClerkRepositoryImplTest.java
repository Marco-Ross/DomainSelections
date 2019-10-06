//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.TicketClerk;
//import com.marco.factory.actors.TicketClerkFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TicketClerkRepositoryImplTest {
//    @Autowired
//    private TicketClerkRepository repository;
//    private TicketClerk ticketClerk;
//
//    private TicketClerk getRepo(){
//        for(TicketClerk ticketClerkA : repository.findAll()){
//            if(ticketClerkA.getEmployeeNumber() == ticketClerk.getEmployeeNumber()){
//                return ticketClerkA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        ticketClerk = TicketClerkFactory.buildTicketClerk(3654, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllTicketClerks() {
//        Set<TicketClerk> arrayList = (Set<TicketClerk>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        TicketClerk ticketClerkTest = this.repository.save(ticketClerk);
//        Assert.assertEquals(ticketClerk, ticketClerkTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "looper";
//        TicketClerk updated = new TicketClerk.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("TicketClerk updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(ticketClerk.getEmployeeNumber());
//        Set<TicketClerk> ticketClerks = (Set<TicketClerk>) repository.findAll();
//        Assert.assertEquals(0, ticketClerks.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<TicketClerk> ticketClerkRead = repository.findById(3654);
//        Assert.assertTrue(ticketClerkRead.isPresent());
//        Assert.assertEquals(ticketClerk.getEmployeeNumber(), ticketClerkRead.get().getEmployeeNumber());
//    }
//}