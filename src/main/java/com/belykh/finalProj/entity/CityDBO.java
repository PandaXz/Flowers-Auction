package com.belykh.finalProj.entity;

/**
 * Created by panda on 8.1.18.
 */
public class CityDBO {
    private Long id;
    private String name;
    private Long countryId;

    public CityDBO(Long id, String name, Long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public CityDBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityDBO cityDBO = (CityDBO) o;

        if (!id.equals(cityDBO.id)) return false;
        if (!name.equals(cityDBO.name)) return false;
        return countryId.equals(cityDBO.countryId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + countryId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CityDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
