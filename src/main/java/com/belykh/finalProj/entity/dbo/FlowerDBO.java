package com.belykh.finalProj.entity.dbo;

/**
 * Created by panda on 7.1.18.
 */
public class FlowerDBO {
    private Long id;
    private String name;
    private String description;

    public FlowerDBO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerDBO flowerDBO = (FlowerDBO) o;

        if (!id.equals(flowerDBO.id)) return false;
        if (!name.equals(flowerDBO.name)) return false;
        return description.equals(flowerDBO.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FlowerDBO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
