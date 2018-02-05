package com.belykh.flowerAuction.entity;

import com.belykh.flowerAuction.entity.dto.LotState;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class LotHeader.
 */
public class LotHeader {
    private Long id;
    private Long flowerId;
    private String flowerName;
    private Long ownerId;
    private String owner;
    private BigDecimal currentPrice;
    private LotState state;
    private int count;
    private LocalDateTime end;
    private String filePath;

    /**
     * Instantiates a new lot header.
     *
     * @param id the id
     * @param flowerId the flower id
     * @param flowerName the flower name
     * @param ownerId the owner id
     * @param owner the owner
     * @param currentPrice the current price
     * @param state the state
     * @param count the count
     * @param end the end
     * @param filePath the file path
     */
    public LotHeader(Long id, Long flowerId, String flowerName, Long ownerId, String owner, BigDecimal currentPrice, LotState state, int count, LocalDateTime end, String filePath) {
        this.id = id;
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.ownerId = ownerId;
        this.owner = owner;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
        this.end = end;
        this.filePath = filePath;
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
     * Gets the flower id.
     *
     * @return the flower id
     */
    public Long getFlowerId() {
        return flowerId;
    }

    /**
     * Sets the flower id.
     *
     * @param flowerId the new flower id
     */
    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }

    /**
     * Gets the flower name.
     *
     * @return the flower name
     */
    public String getFlowerName() {
        return flowerName;
    }

    /**
     * Sets the flower name.
     *
     * @param flowerName the new flower name
     */
    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    /**
     * Gets the owner id.
     *
     * @return the owner id
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the owner id.
     *
     * @param ownerId the new owner id
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * Gets the owner.
     *
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner.
     *
     * @param owner the new owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Gets the current price.
     *
     * @return the current price
     */
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    /**
     * Sets the current price.
     *
     * @param currentPrice the new current price
     */
    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public LotState getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public void setState(LotState state) {
        this.state = state;
    }

    /**
     * Gets the count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count.
     *
     * @param count the new count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Gets the end.
     *
     * @return the end
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * Sets the end.
     *
     * @param end the new end
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * Gets the file path.
     *
     * @return the file path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path.
     *
     * @param filePath the new file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotHeader lotHeader = (LotHeader) o;
        return count == lotHeader.count &&
                Objects.equals(id, lotHeader.id) &&
                Objects.equals(flowerId, lotHeader.flowerId) &&
                Objects.equals(flowerName, lotHeader.flowerName) &&
                Objects.equals(ownerId, lotHeader.ownerId) &&
                Objects.equals(owner, lotHeader.owner) &&
                Objects.equals(currentPrice, lotHeader.currentPrice) &&
                state == lotHeader.state &&
                Objects.equals(end, lotHeader.end) &&
                Objects.equals(filePath, lotHeader.filePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, flowerId, flowerName, ownerId, owner, currentPrice, state, count, end, filePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LotHeader{" +
                "id=" + id +
                ", flowerId=" + flowerId +
                ", flowerName='" + flowerName + '\'' +
                ", ownerId=" + ownerId +
                ", owner='" + owner + '\'' +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                ", end=" + end +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
