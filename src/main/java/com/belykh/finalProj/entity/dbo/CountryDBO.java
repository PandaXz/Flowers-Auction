package com.belykh.finalProj.entity.dbo;

/**
 * Created by panda on 8.1.18.
 */
public class CountryDBO {

    private Long id;
    private String name;

    public CountryDBO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryDBO countryDBO = (CountryDBO) o;

        if (!id.equals(countryDBO.id)) return false;
        return name.equals(countryDBO.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CountryDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
