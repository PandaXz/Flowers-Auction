package com.belykh.finalProj.entity;

import java.util.Objects;

public class Address {
    private Long addressId;
    private Long cityId;
    private String street;
    private int houseNumber;
    private String cityName;

    public Address(Long addressId, Long cityId, String street, int houseNumber, String cityName) {
        this.addressId = addressId;
        this.cityId = cityId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
    }

    public Address() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(addressId, address.addressId) &&
                Objects.equals(cityId, address.cityId) &&
                Objects.equals(street, address.street) &&
                Objects.equals(cityName, address.cityName) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(addressId, cityId, street, houseNumber, cityName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", cityId=" + cityId +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
