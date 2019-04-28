package com.marco.repository.impl.bookingimpl;

import com.marco.domain.actors.Customer;
import com.marco.domain.bookings.Refund;
import com.marco.domain.credentials.LoginDetail;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.bookings.RefundFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.RefundRepository;
import com.marco.repository.repositoryinterfaces.bookingrepo.ReportRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RefundRepositoryImplTest {
    private RefundRepository repository;
    private Refund refund;
    private LoginDetail loginDetail;

    @Before
    public void setUp() throws Exception {
        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "54587896321", 250);
        loginDetail = LoginDetailFactory.getLoginDetail("marcuz", "pass01", customer);

        this.repository = RefundRepositoryImpl.getRepository();
        refund = RefundFactory.getRefund(20, loginDetail);
        this.repository.create(refund);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<Refund> arrayList = repository.getAllRefunds();
        arrayList.clear();
    }

    @Test
    public void getAllRefunds() {
        ArrayList<Refund> arrayList = repository.getAllRefunds();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        Refund refund = RefundFactory.getRefund(20, loginDetail);
        Refund refundTest = this.repository.create(refund);

        Assert.assertEquals(refund, refundTest);
    }

    @Test
    public void update() {
        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "54587896321", 250 + refund.getRefundAmount());
        loginDetail = LoginDetailFactory.getLoginDetail("marcuz", "pass01", customer);

        Refund refund = RefundFactory.getRefund(20, loginDetail);

        this.repository.update(refund);
    }

    @Test
    public void delete() {
    }

    @Test
    public void read() {
    }
}