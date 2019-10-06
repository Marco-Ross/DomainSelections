package com.marco.service.actors.impl;

import com.marco.domain.actors.Announcer;
import com.marco.factory.actors.AnnouncerFactory;
import com.marco.service.actors.actorservice.AnnouncerService;
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

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AnnouncerServiceImplTest {
    @Autowired
    @Qualifier("AnnouncerServiceImpl")
    private AnnouncerService service;
    private Announcer announcer;

    private Announcer getRepo(){
        for(Announcer announcerA : service.getAllAnnouncers()){
            if(announcerA.getEmployeeNumber() == announcer.getEmployeeNumber()){
                return announcerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        announcer = AnnouncerFactory.buildAnnouncer(3654, "marco", "ross");
    }

    @Test
    public void d_getAllAnnouncers() {
        ArrayList<Announcer> arrayList = service.getAllAnnouncers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Announcer announcerTest = this.service.create(announcer);
        Assert.assertEquals(announcer.getEmployeeNumber(), announcerTest.getEmployeeNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        Announcer updated = new Announcer.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Announcer updated");
    }

    @Test
    public void e_delete() {
        this.service.delete(announcer.getEmployeeNumber());

        ArrayList<Announcer> arrayList = service.getAllAnnouncers();
        Assert.assertEquals(0, arrayList.size());
    }

    @Test
    public void b_read() {
        Optional<Announcer> announcerRead = this.service.read(announcer.getEmployeeNumber());
        Assert.assertTrue(announcerRead.isPresent());
        Assert.assertEquals(announcer.getEmployeeNumber(), announcerRead.get().getEmployeeNumber());
    }
}