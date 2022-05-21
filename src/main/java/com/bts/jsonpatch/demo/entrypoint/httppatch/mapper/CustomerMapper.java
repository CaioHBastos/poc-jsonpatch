package com.bts.jsonpatch.demo.entrypoint.httppatch.mapper;

import com.bts.jsonpatch.demo.dataprovider.entity.CustomerEntity;
import com.bts.jsonpatch.demo.entrypoint.model.request.CustomerModelRequest;
import com.bts.jsonpatch.demo.entrypoint.model.request.CustomerUpdateModelRequest;
import com.bts.jsonpatch.demo.entrypoint.model.response.CustomerModelResponse;
import com.bts.jsonpatch.demo.usecase.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface CustomerMapper {

    List<CustomerModelResponse> map(List<Customer> customers);
    Customer map(CustomerModelRequest customerModelRequest);
    CustomerModelResponse map(Customer customer);
    CustomerUpdateModelRequest mapUpdate(CustomerEntity customerEntity);
    CustomerUpdateModelRequest mapUpdate(Customer customer);
    void mapUpdate(@MappingTarget CustomerEntity customerEntity, CustomerUpdateModelRequest customerUpdateModelRequest);
    void mapUpdate(@MappingTarget Customer customer, CustomerUpdateModelRequest customerUpdateModelRequest);
    CustomerModelResponse map(CustomerEntity customer);
}
