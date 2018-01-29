package com.belykh.finalProj.entity;

import java.util.Objects;

public class Address {
    private Long addressId;
    private Long cityId;
    private Long countryId;
    private String street;
    private int houseNumber;
    private String cityName;
    private String countryName;

    public Address(Long addressId, Long cityId, Long countryId, String street, int houseNumber, String cityName, String countryName) {
        this.addressId = addressId;
        this.cityId = cityId;
        this.countryId = countryId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
        this.countryName = countryName;
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

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
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

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(addressId, address.addressId) &&
                Objects.equals(cityId, address.cityId) &&
                Objects.equals(countryId, address.countryId) &&
                Objects.equals(street, address.street) &&
                Objects.equals(cityName, address.cityName) &&
                Objects.equals(countryName, address.countryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(addressId, cityId, countryId, street, houseNumber, cityName, countryName);
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", cityId=" + cityId +
                ", countryId=" + countryId +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
