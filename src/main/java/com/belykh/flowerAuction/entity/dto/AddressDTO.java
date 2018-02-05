package com.belykh.flowerAuction.entity.dto;

/**
 * The Class AddressDTO.
 */
public class AddressDTO {
    private Long id;
    private String street;
    private int houseNumber;
    private Long cityId;

    /**
     * Instantiates a new address DTO.
     *
     * @param id the id
     * @param street the street
     * @param houseNumber the house number
     * @param cityId the city id
     */
    public AddressDTO(Long id, String street, int houseNumber, Long cityId) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.cityId = cityId;
    }

    /**
     * Instantiates a new address DTO.
     */
    public AddressDTO() {
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO addressDTO = (AddressDTO) o;

        if (houseNumber != addressDTO.houseNumber) return false;
        if (!id.equals(addressDTO.id)) return false;
        if (!street.equals(addressDTO.street)) return false;
        return cityId.equals(addressDTO.cityId);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber;
        result = 31 * result + cityId.hashCode();
        return result;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {

        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AddressDTO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", cityId=" + cityId +
                '}';
    }
}
