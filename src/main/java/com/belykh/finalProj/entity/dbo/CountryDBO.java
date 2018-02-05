package com.belykh.finalProj.entity.dbo;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryDBO.
 */
public class CountryDBO {

    private Long id;
    private String name;

    /**
     * Instantiates a new country DBO.
     *
     * @param id the id
     * @param name the name
     */
    public CountryDBO(Long id, String name) {
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

        CountryDBO countryDBO = (CountryDBO) o;

        if (!id.equals(countryDBO.id)) return false;
        return name.equals(countryDBO.name);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CountryDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
