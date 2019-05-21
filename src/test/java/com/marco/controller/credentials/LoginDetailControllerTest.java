package com.marco.controller.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Profile;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.factory.credentials.ProfileFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginDetailControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/logindetail";

    @Test
    public void a_create() {

        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 20, "54587896321", 250);
        Profile profile = ProfileFactory.buildProfile(2,"dookie");
        LoginDetail loginDetail = LoginDetailFactory.buildLoginDetail("marolo", "passwordo1", customer, profile);

        ResponseEntity<LoginDetail> postResponse = restTemplate.postForEntity(baseURL + "/create", loginDetail, LoginDetail.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        LoginDetail loginDetail = restTemplate.getForObject(baseURL + "/read/marolo", LoginDetail.class);
        LoginDetail updated = new LoginDetail.Builder().copy(loginDetail).password("sleeper1").build();
        restTemplate.put(baseURL + "/update", updated);

        LoginDetail updatedReport = restTemplate.getForObject(baseURL + "/read/marolo", LoginDetail.class);

        assertNotNull(updatedReport);
        assertEquals(updated.getPassword(), updatedReport.getPassword());
    }

    @Test
    public void e_delete() {
        LoginDetail loginDetail = restTemplate.getForObject(baseURL + "/read/marolo", LoginDetail.class);
        assertNotNull(loginDetail);
        assertEquals("marolo", loginDetail.getUsername());

        restTemplate.delete(baseURL + "/delete/" + loginDetail.getUsername());
        loginDetail = restTemplate.getForObject(baseURL + "/read/marolo", LoginDetail.class);

        assertNull(loginDetail);
    }

    @Test
    public void b_read() {
        ResponseEntity<LoginDetail> loginDetailResponseEntity = restTemplate.getForEntity(baseURL + "/read/marolo", LoginDetail.class);
        assertNotNull(loginDetailResponseEntity.getBody());
        assertEquals("marolo", loginDetailResponseEntity.getBody().getUsername());
    }

    @Test
    public void d_getAllAnnouncers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ReportHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}