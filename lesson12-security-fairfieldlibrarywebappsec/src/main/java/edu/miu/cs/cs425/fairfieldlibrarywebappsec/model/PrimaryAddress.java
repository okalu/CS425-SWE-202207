package edu.miu.cs.cs425.fairfieldlibrarywebappsec.model;

import javax.persistence.*;

@Entity
@Table(name = "primary_addresses")
public class PrimaryAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne(mappedBy = "primaryAddress")
    private Publisher publisher;

    public PrimaryAddress() {
    }

    public PrimaryAddress(Integer addressId, String street, String city, String state, String zipCode, Publisher publisher) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.publisher = publisher;
    }

    public Integer getAddrId() {
        return addressId;
    }

    public void setAddrId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
