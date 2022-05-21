package com.bts.jsonpatch.demo.usecase.domain;

public class Address {

    private String street;
    private String number;
    private String zipcode;
    private String city;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address() {
    }

    public Address(String street, String number, String zipcode, String city, String country) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }
}
