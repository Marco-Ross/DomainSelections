package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Manager;
import com.marco.factory.actors.ManagerFactory;
import com.marco.repository.actors.impl.ManagerRepositoryImpl;
import com.marco.repository.actors.actorrepo.ManagerRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerRepositoryImplTest {
    @Autowired
    @Qualifier("ManagerRepoImpl")
    private ManagerRepository repository;
    private Manager manager;

    private Manager getRepo(){
        for(Manager managerA : repository.getAllManagers()){
            if(managerA.getEmployeeNumber() == manager.getEmployeeNumber()){
                return managerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        manager = ManagerFactory.buildManager("marco", "ross", 5532);
    }

    @Test
    public void d_getAllManagers() {
        ArrayList<Manager> arrayList = repository.getAllManagers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        Manager managerTest = this.repository.create(manager);
        Assert.assertEquals(manager, managerTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "rusoo";
        Manager updated = new Manager.Builder().copy(getRepo()).surname(surname).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Manager updated");
    }

    @Test
    public void e_delete() {
        repository.delete(manager.getEmployeeNumber());
        ArrayList<Manager> managerList = repository.getAllManagers();
        Assert.assertEquals(0, managerList.size());
    }

    @Test
    public void b_read() {
        Manager managerRead = repository.read(5532);
        Assert.assertEquals(manager.getEmployeeNumber(), managerRead.getEmployeeNumber());
    }
}