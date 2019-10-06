package com.marco.repository.credentials.credentialrepo;

import com.marco.domain.credentials.Payment;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
