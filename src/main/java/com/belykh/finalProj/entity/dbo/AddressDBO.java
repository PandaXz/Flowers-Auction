package com.belykh.finalProj.entity.dbo;

/**
 * Created by panda on 7.1.18.
 */
public class AddressDBO {
    private Long id;
    private String street;
    private int houseNumber;
    private Long cityId;

    public AddressDBO(Long id, String street, int houseNumber, Long cityId) {
        this.id = id;
        this.street = street;
        this.houseNumber = houseNumber;
        this.cityId = cityId;
    }

    public AddressDBO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDBO addressDBO = (AddressDBO) o;

        if (houseNumber != addressDBO.houseNumber) return false;
        if (!id.equals(addressDBO.id)) return false;
        if (!street.equals(addressDBO.street)) return false;
        return cityId.equals(addressDBO.cityId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber;
        result = 31 * result + cityId.hashCode();
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "AddressDBO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", cityId=" + cityId +
                '}';
    }
}
