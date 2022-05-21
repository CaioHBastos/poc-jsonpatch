package com.bts.jsonpatch.demo.entrypoint.model.request;

import javax.validation.constraints.NotBlank;

public class CustomerUpdateModelRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String birthDate;
    private AddressModelRequest address;

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

    public AddressModelRequest getAddress() {
        return address;
    }

    public void setAddress(AddressModelRequest address) {
        this.address = address;
    }

    public CustomerUpdateModelRequest() {
    }

    public CustomerUpdateModelRequest(String firstName, String lastName, String birthDate, AddressModelRequest address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }
}
