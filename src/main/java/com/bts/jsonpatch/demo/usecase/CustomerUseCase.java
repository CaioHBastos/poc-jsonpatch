package com.bts.jsonpatch.demo.usecase;

import com.bts.jsonpatch.demo.usecase.domain.Customer;

import java.util.List;

public interface CustomerUseCase {

    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Customer getByIdCustomer(Long id);
    Customer updateCustomer(Customer customer);
}
