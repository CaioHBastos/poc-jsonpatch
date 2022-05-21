package com.bts.jsonpatch.demo.entrypoint.model.response;

public class CustomerModelResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private AddressModelResponse address;

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

    public AddressModelResponse getAddress() {
        return address;
    }

    public void setAddress(AddressModelResponse address) {
        this.address = address;
    }

    public CustomerModelResponse() {
    }

    public CustomerModelResponse(Long id, String firstName, String lastName, String birthDate, AddressModelResponse address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }
}
