package com.belykh.flowerAuction.entity;

import java.util.Objects;

/**
 * The Class Address.
 */
public class Address {
    private Long addressId;
    private Long cityId;
    private String street;
    private int houseNumber;
    private String cityName;

    /**
     * Instantiates a new address.
     *
     * @param addressId the address id
     * @param cityId the city id
     * @param street the street
     * @param houseNumber the house number
     * @param cityName the city name
     */
    public Address(Long addressId, Long cityId, String street, int houseNumber, String cityName) {
        this.addressId = addressId;
        this.cityId = cityId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.cityName = cityName;
    }

    /**
     * Instantiates a new address.
     */
    public Address() {
    }

    /**
     * Gets the address id.
     *
     * @return the address id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Sets the address id.
     *
     * @param addressId the new address id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the city id.
     *
     * @return the city id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * Sets the city id.
     *
     * @param cityId the new city id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param street the new street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the house number.
     *
     * @return the house number
     */
    public int getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets the house number.
     *
     * @param houseNumber the new house number
     */
    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     *
     * @param cityName the new city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(addressId, cityId, street, houseNumber, cityName);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
