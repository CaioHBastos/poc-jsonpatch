package com.bts.jsonpatch.demo.dataprovider.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String birthDate;

    @Embedded
    private AdressEntity address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public AdressEntity getAddress() {
        return address;
    }

    public void setAddress(AdressEntity address) {
        this.address = address;
    }

    public CustomerEntity() {
    }

    public CustomerEntity(Long id, String firstName, String lastName, String birthDate, AdressEntity address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }
}
