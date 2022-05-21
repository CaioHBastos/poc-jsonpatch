package com.bts.jsonpatch.demo.dataprovider.impl;

import com.bts.jsonpatch.demo.dataprovider.mapper.CustomerDataProviderMapper;
import com.bts.jsonpatch.demo.dataprovider.entity.CustomerEntity;
import com.bts.jsonpatch.demo.dataprovider.repository.CustomerRepository;
import com.bts.jsonpatch.demo.usecase.domain.Customer;
import com.bts.jsonpatch.demo.usecase.gateway.CustomerDataBaseGateway;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDataBaseImpl implements CustomerDataBaseGateway {

    private final CustomerDataProviderMapper customerMapper = Mappers.getMapper(CustomerDataProviderMapper.class);
    private final CustomerRepository customerRepository;

    public CustomerDataBaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerEntity> customersEntity = customerRepository.findAll();

        return customerMapper.map(customersEntity);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity newCustomerEntity = customerMapper.map(customer);
        CustomerEntity customerEntity = customerRepository.save(newCustomerEntity);

        return customerMapper.map(customerEntity);
    }

    @Override
    public Optional<Customer> getByIdCustomer(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::map);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        CustomerEntity customerEntityUpdated = customerMapper.map(customer);
        CustomerEntity customerEntity = customerRepository.save(customerEntityUpdated);

        return customerMapper.map(customerEntity);
    }
}
