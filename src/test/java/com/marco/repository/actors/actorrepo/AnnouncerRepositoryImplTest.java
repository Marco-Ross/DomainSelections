package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Announcer;
import com.marco.factory.actors.AnnouncerFactory;
import com.marco.repository.actors.impl.AnnouncerRepositoryImpl;
import com.marco.repository.actors.actorrepo.AnnouncerRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnnouncerRepositoryImplTest {
    @Autowired
    @Qualifier("AnnouncerFirstRepoImpl")
    private AnnouncerRepository repository;
    private Announcer announcer;

    private Announcer getRepo(){
        for(Announcer announcerA : repository.getAllAnnouncers()){
            if(announcerA.getEmployeeNumber() == announcer.getEmployeeNumber()){
                return announcerA;
            }
        }
         return null;
    }

    @Before
    public void setUp() throws Exception {
        //this.repository = AnnouncerRepositoryImpl.getRepository(); //was used to initialize the repository impl. and initialize the dataSet
        announcer = AnnouncerFactory.buildAnnouncer("marco", "ross", 3654);
    }

    @Test
    public void d_getAllSecurity() {
        ArrayList<Announcer> arrayList = repository.getAllAnnouncers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Announcer announcerTest = this.repository.create(announcer);
        Assert.assertEquals(announcer, announcerTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        Announcer updated = new Announcer.Builder().copy(getRepo()).surname(surname).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Announcer updated");
    }

    @Test
    public void e_delete() {
        Assert.assertNotNull(getRepo());
        Announcer saved = getRepo();
        this.repository.delete(saved.getEmployeeNumber());

        ArrayList<Announcer> arrayList = repository.getAllAnnouncers();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void b_read() {
        Assert.assertNotNull(getRepo());
        Announcer announcerList = getRepo();
        Announcer announcerRead = this.repository.read(announcerList.getEmployeeNumber());

        Assert.assertEquals(announcerList, announcerRead);
    }
}