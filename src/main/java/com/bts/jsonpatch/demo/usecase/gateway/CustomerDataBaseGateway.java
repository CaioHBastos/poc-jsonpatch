package com.bts.jsonpatch.demo.usecase.gateway;

import com.bts.jsonpatch.demo.usecase.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDataBaseGateway {

    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Optional<Customer> getByIdCustomer(Long id);
    Customer updateCustomer(Customer customer);
}
