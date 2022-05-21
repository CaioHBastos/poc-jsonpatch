package com.bts.jsonpatch.demo.entrypoint.controller;

import com.bts.jsonpatch.demo.entrypoint.PatchMediaType;
import com.bts.jsonpatch.demo.entrypoint.httppatch.PatchHelper;
import com.bts.jsonpatch.demo.entrypoint.httppatch.mapper.CustomerMapper;
import com.bts.jsonpatch.demo.entrypoint.model.request.CustomerModelRequest;
import com.bts.jsonpatch.demo.entrypoint.model.request.CustomerUpdateModelRequest;
import com.bts.jsonpatch.demo.entrypoint.model.response.CustomerModelResponse;
import com.bts.jsonpatch.demo.usecase.CustomerUseCase;
import com.bts.jsonpatch.demo.usecase.domain.Customer;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonMergePatch;
import javax.json.JsonPatch;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "bts/v1/customers")
public class CustomerController {

    private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
    private final CustomerUseCase customerUseCase;
    private final PatchHelper patchHelper;

    public CustomerController(CustomerUseCase customerUseCase,
                              PatchHelper patchHelper) {

        this.customerUseCase = customerUseCase;
        this.patchHelper = patchHelper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerModelResponse>> getAll() {
        List<Customer> customers = customerUseCase.getAllCustomers();
        List<CustomerModelResponse> customersModel = customerMapper.map(customers);

        return ResponseEntity.ok(customersModel);
    }

    @PostMapping
    public ResponseEntity<CustomerModelResponse> create(@RequestBody @Valid CustomerModelRequest customerModelRequest) {
        Customer newCustomer = customerMapper.map(customerModelRequest);
        Customer customer = customerUseCase.createCustomer(newCustomer);
        CustomerModelResponse customerModelResponse = customerMapper.map(customer);

        return new ResponseEntity<>(customerModelResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id_customer}")
    public ResponseEntity<CustomerModelResponse> getById(@PathVariable("id_customer") Long idCustomer) {
        Customer customer = customerUseCase.getByIdCustomer(idCustomer);
        CustomerModelResponse customerModelResponse = customerMapper.map(customer);

        return ResponseEntity.ok(customerModelResponse);
    }

    @PatchMapping(path = "{id_customer}", consumes = PatchMediaType.APPLICATION_MERGE_PATCH_VALUE)
    public ResponseEntity<CustomerModelResponse> udpate(@PathVariable("id_customer") Long idCustomer,
                                                        @RequestBody JsonMergePatch mergePatchDocument) {

        Customer customer = customerUseCase.getByIdCustomer(idCustomer);
        CustomerUpdateModelRequest customerUpdateModelRequest = customerMapper.mapUpdate(customer);

        CustomerUpdateModelRequest customerUpdateModelRequestPatched = patchHelper.mergePatch(
                mergePatchDocument, customerUpdateModelRequest, CustomerUpdateModelRequest.class
        );

        customerMapper.mapUpdate(customer, customerUpdateModelRequestPatched);
        Customer customerUpdated = customerUseCase.updateCustomer(customer);
        CustomerModelResponse customerModelResponse = customerMapper.map(customerUpdated);

        return ResponseEntity.ok(customerModelResponse);
    }

    @PatchMapping(path = "{id_customer}", consumes = PatchMediaType.APPLICATION_JSON_PATCH_VALUE)
    public ResponseEntity<CustomerModelResponse> updateContact(@PathVariable("id_customer") Long idCustomer,
                                                               @RequestBody JsonPatch patchDocument) {

        Customer customer = customerUseCase.getByIdCustomer(idCustomer);
        CustomerUpdateModelRequest customerUpdateModelRequest = customerMapper.mapUpdate(customer);;

        CustomerUpdateModelRequest customerUpdateModelRequestPatched = patchHelper.patch(
                patchDocument, customerUpdateModelRequest, CustomerUpdateModelRequest.class
        );

        customerMapper.mapUpdate(customer, customerUpdateModelRequestPatched);
        Customer customerUpdated = customerUseCase.updateCustomer(customer);
        CustomerModelResponse customerModelResponse = customerMapper.map(customerUpdated);

        return ResponseEntity.ok(customerModelResponse);
    }
}
