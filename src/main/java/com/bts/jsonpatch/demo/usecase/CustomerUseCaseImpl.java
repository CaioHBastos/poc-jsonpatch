package com.bts.jsonpatch.demo.usecase;

import com.bts.jsonpatch.demo.usecase.domain.Customer;
import com.bts.jsonpatch.demo.usecase.gateway.CustomerDataBaseGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerDataBaseGateway customerDataBaseGateway;

    public CustomerUseCaseImpl(CustomerDataBaseGateway customerDataBaseGateway) {
        this.customerDataBaseGateway = customerDataBaseGateway;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDataBaseGateway.getAllCustomers();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDataBaseGateway.createCustomer(customer);
    }

    @Override
    public Customer getByIdCustomer(Long id) {
        return customerDataBaseGateway.getByIdCustomer(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDataBaseGateway.updateCustomer(customer);
    }
}
