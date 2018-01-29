package com.belykh.finalProj.entity.dbo;

import java.util.Objects;

/**
 * Created by panda on 14.1.18.
 */
public class LotStoryDBO {
    private Long id;
    private Long userId;
    private Long lotId;
    private Double price;

    public LotStoryDBO(Long id, Long userId, Long lotId, Double price) {
        this.id = id;
        this.userId = userId;
        this.lotId = lotId;
        this.price = price;
    }

    public LotStoryDBO() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotStoryDBO that = (LotStoryDBO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(lotId, that.lotId) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, lotId, price);
    }

    @Override
    public String toString() {
        return "LotStoryDBO{" +
                "id=" + id +
                ", userId=" + userId +
                ", lotId=" + lotId +
                ", price=" + price +
                '}';
    }
}
