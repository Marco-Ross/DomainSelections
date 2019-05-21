package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.factory.credentials.ProfileFactory;
import com.marco.repository.credentials.impl.LoginDetailRepositoryImpl;
import com.marco.repository.credentials.credentialrepo.LoginDetailRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginDetailRepositoryImplTest {
    @Autowired
    @Qualifier("LoginDetailRepoImpl")
    private LoginDetailRepository repository;
    private LoginDetail loginDetail;

    private LoginDetail getRepo(){
        for(LoginDetail loginDetailA : repository.getAllLoginDetails()){
            if(loginDetailA.getUsername().equals(loginDetail.getUsername())){
                return loginDetailA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 20, "54587896321", 250);
        Profile profile = ProfileFactory.buildProfile(2,"pookie");
        loginDetail = LoginDetailFactory.buildLoginDetail("marolo", "passwordo1", customer, profile);
    }

    @Test
    public void d_getAllLoginDetails() {
        Set<LoginDetail> set = repository.getAllLoginDetails();
        Assert.assertEquals(1, set.size());
    }

    @Test
    public void a_create() {
        LoginDetail loginDetailTest = this.repository.create(loginDetail);
        Assert.assertEquals(loginDetail, loginDetailTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String username = "mynewUsername";
        LoginDetail updated = new LoginDetail.Builder().copy(getRepo()).username(username).build();

        this.repository.update(updated);

        Assert.assertSame(username, updated.getUsername());
        System.out.println("LoginDetails updated");
    }

    @Test
    public void e_delete() {
        repository.delete(loginDetail.getUsername());
        Set<LoginDetail> loginDetails = repository.getAllLoginDetails();
        Assert.assertEquals(0, loginDetails.size());
    }

    @Test
    public void b_read() {
        LoginDetail loginDetailRead = repository.read("marolo");
        Assert.assertEquals(loginDetail.getUsername(), loginDetailRead.getUsername());
    }
}