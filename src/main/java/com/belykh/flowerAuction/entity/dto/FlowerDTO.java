package com.belykh.flowerAuction.entity.dto;

import java.util.Objects;

/**
 * The Class FlowerDTO.
 */
public class FlowerDTO {
    private Long id;
    private String name;

    /**
     * Instantiates a new flower DTO.
     *
     * @param id the id
     * @param name the name
     */
    public FlowerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
        FlowerDTO flowerDTO = (FlowerDTO) o;
        return Objects.equals(id, flowerDTO.id) &&
                Objects.equals(name, flowerDTO.name);
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
        return "FlowerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
