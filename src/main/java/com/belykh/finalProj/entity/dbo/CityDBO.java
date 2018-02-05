package com.belykh.finalProj.entity.dbo;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class CityDBO.
 */
public class CityDBO {
    private Long id;
    private String name;

    /**
     * Instantiates a new city DBO.
     *
     * @param id the id
     * @param name the name
     */
    public CityDBO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Instantiates a new city DBO.
     */
    public CityDBO() {
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
        CityDBO cityDBO = (CityDBO) o;
        return Objects.equals(id, cityDBO.id) &&
                Objects.equals(name, cityDBO.name);
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
        return "CityDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
