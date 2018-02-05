package com.belykh.flowerAuction.entity.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * The Class LotStoryDTO.
 */
public class LotStoryDTO {
    private Long id;
    private Long userId;
    private Long lotId;
    private BigDecimal price;

    /**
     * Instantiates a new lot story DTO.
     *
     * @param id the id
     * @param userId the user id
     * @param lotId the lot id
     * @param price the price
     */
    public LotStoryDTO(Long id, Long userId, Long lotId, BigDecimal price) {
        this.id = id;
        this.userId = userId;
        this.lotId = lotId;
        this.price = price;
    }

    /**
     * Instantiates a new lot story DTO.
     */
    public LotStoryDTO() {
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
     * Gets the user id.
     *
     * @return the user id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the lot id.
     *
     * @return the lot id
     */
    public Long getLotId() {
        return lotId;
    }

    /**
     * Sets the lot id.
     *
     * @param lotId the new lot id
     */
    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotStoryDTO that = (LotStoryDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(lotId, that.lotId) &&
                Objects.equals(price, that.price);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, userId, lotId, price);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LotStoryDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", lotId=" + lotId +
                ", price=" + price +
                '}';
    }
}
