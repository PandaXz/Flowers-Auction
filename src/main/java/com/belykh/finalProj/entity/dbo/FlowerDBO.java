package com.belykh.finalProj.entity.dbo;

import java.util.Objects;

/**
 * Created by panda on 7.1.18.
 */
public class FlowerDBO {
    private Long id;
    private String name;

    public FlowerDBO(Long id, String name) {
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
        FlowerDBO flowerDBO = (FlowerDBO) o;
        return Objects.equals(id, flowerDBO.id) &&
                Objects.equals(name, flowerDBO.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "FlowerDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
