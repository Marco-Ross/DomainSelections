package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.TicketChecker;
import com.marco.factory.actors.TicketCheckerFactory;
import com.marco.repository.actors.impl.TicketCheckerRepositoryImpl;
import com.marco.repository.actors.actorrepo.TicketCheckerRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketCheckerRepositoryImplTest {
    @Autowired
    @Qualifier("TicketCheckerRepoImpl")
    private TicketCheckerRepository repository;
    private TicketChecker ticketChecker;

    private TicketChecker getRepo(){
        for(TicketChecker ticketCheckerA : repository.getAllTicketCheckers()){
            if(ticketCheckerA.getEmployeeNumber() == ticketChecker.getEmployeeNumber()){
                return ticketCheckerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        ticketChecker = TicketCheckerFactory.buildTicketChecker("marco", "ross", 3654);
    }

    @Test
    public void d_getAllSecurity() {
        ArrayList<TicketChecker> arrayList = repository.getAllTicketCheckers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        TicketChecker ticketCheckerTest = this.repository.create(ticketChecker);
        Assert.assertEquals(ticketChecker, ticketCheckerTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        String name = "marcoopie";
        TicketChecker updated = new TicketChecker.Builder().copy(getRepo()).surname(surname).name(name).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("TicketChecker updated");
    }

    @Test
    public void e_delete() {
        repository.delete(ticketChecker.getEmployeeNumber());
        ArrayList<TicketChecker> ticketCheckers = repository.getAllTicketCheckers();
        Assert.assertEquals(0, ticketCheckers.size());
    }

    @Test
    public void b_read() {
        TicketChecker ticketCheckersRead = repository.read(3654);
        Assert.assertEquals(ticketChecker.getEmployeeNumber(), ticketCheckersRead.getEmployeeNumber());
    }
}