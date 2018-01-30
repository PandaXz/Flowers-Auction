package com.belykh.finalProj.entity.dbo;

import java.util.Objects;

/**
 * Created by panda on 8.1.18.
 */
public class CityDBO {
    private Long id;
    private String name;

    public CityDBO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDBO cityDBO = (CityDBO) o;
        return Objects.equals(id, cityDBO.id) &&
                Objects.equals(name, cityDBO.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "CityDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
