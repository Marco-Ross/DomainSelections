package com.marco.repository.repositoryinterfaces.bookingrepo;

import com.marco.domain.actors.Customer;
import com.marco.domain.bookings.Refund;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface RefundRepository extends RepositoryGI<Refund, Customer> {
    ArrayList<Refund> getAllRefunds();
}
