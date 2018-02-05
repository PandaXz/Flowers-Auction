package com.belykh.flowerAuction.entity.dto;

import java.util.Objects;


/**
 * The Class CityDTO.
 */
public class CityDTO {
    private Long id;
    private String name;

    /**
     * Instantiates a new city DTO.
     *
     * @param id the id
     * @param name the name
     */
    public CityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Instantiates a new city DTO.
     */
    public CityDTO() {
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
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return Objects.equals(id, cityDTO.id) &&
                Objects.equals(name, cityDTO.name);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
