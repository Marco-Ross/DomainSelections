//package com.marco.repository.actors.impl;
//
//import com.marco.domain.actors.Customer;
//import com.marco.repository.actors.actorrepo.CustomerRepository;
//import org.springframework.stereotype.Repository;
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("CustomerRepoImpl")
//public class CustomerRepositoryImpl implements CustomerRepository {
//    private Set<Customer> customers;
//
//    private CustomerRepositoryImpl(){
//        this.customers = new HashSet<>();
//    }
//
//    @Override
//    public Customer create(Customer customer) {
//        this.customers.add(customer);
//        for(Customer customerC : customers){
//            if(customer.equals(customerC)){
//                return customerC;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Customer update(Customer customer) {
//        for(Customer customerC : customers){
//           if(customer.getIdNumber().equals(customerC.getIdNumber())){
//               this.customers.remove(customerC);
//               this.customers.add(customer);
//               return customer;
//           }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(String customerId) {
//        for(Customer customerC : customers){
//            if(customerC.getIdNumber().equals(customerId)){
//                this.customers.remove(customerC);
//            }
//        }
//    }
//
//    @Override
//    public Customer read(String customerId) {
//        for(Customer customerC : customers){
//            if(customerId.equals(customerC.getIdNumber())){
//                return customerC;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public Set<Customer> getAllCustomers() {
//        return this.customers;
//    }
//}
