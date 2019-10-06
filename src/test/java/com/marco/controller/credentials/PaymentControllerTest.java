package com.marco.controller.credentials;

import com.marco.domain.credentials.Payment;
import com.marco.factory.credentials.PaymentFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/payment";
    private Payment payment;

    @Before
    public void setUp() throws Exception {
        payment = PaymentFactory.buildPayment(12, 50, "12345678910");
    }

    @Test
    public void a_create() {
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(baseURL + "/create", payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Ignore
    public void c_update() {
        //Cannot update payments
    }

    @Test
    public void e_delete() {
        Payment paymentResponse = restTemplate.getForObject(baseURL + "/read/" + payment.getPaymentID(), Payment.class);
        assertNotNull(paymentResponse);
        assertSame(payment.getPaymentID(), paymentResponse.getPaymentID());

        restTemplate.delete(baseURL + "/delete/" + paymentResponse.getPaymentID(), void.class);

        paymentResponse = restTemplate.getForObject(baseURL + "/read/" + payment.getPaymentID(), Payment.class);

        assertNull(paymentResponse);
    }

    @Test
    public void b_read() {
        Payment paymentResponse = restTemplate.getForObject(baseURL + "/read/" + payment.getPaymentID(), Payment.class);

        assertNotNull(paymentResponse);
        assertSame(12, paymentResponse.getPaymentID());
    }

    @Test
    public void d_getAllPayments() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("PaymentHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}