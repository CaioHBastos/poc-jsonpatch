package com.bts.jsonpatch.demo.dataprovider.mapper;

import com.bts.jsonpatch.demo.dataprovider.entity.CustomerEntity;
import com.bts.jsonpatch.demo.usecase.domain.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerDataProviderMapper {

    CustomerEntity map(Customer customer);
    List<Customer> map(List<CustomerEntity> customersEntity);
    Customer map(CustomerEntity customerEntity);
}
