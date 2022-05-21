package com.bts.jsonpatch.demo.dataprovider.repository;

import com.bts.jsonpatch.demo.dataprovider.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
