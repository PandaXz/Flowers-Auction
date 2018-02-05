package com.belykh.flowerAuction.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class LotDTO.
 */
public class LotDTO {
    private Long id;
    private Long buyerId;
    private Long ownerId;
    private Long flowerId;
    private Long addressId;
    private BigDecimal startPrice;
    private BigDecimal currentPrice;
    private LotState state;
    private int count;
    private LocalDateTime end;
    private String description;
    private String filePath;

    /**
     * Instantiates a new lot DTO.
     *
     * @param id the id
     * @param buyerId the buyer id
     * @param ownerId the owner id
     * @param flowerId the flower id
     * @param addressId the address id
     * @param startPrice the start price
     * @param currentPrice the current price
     * @param state the state
     * @param count the count
     * @param end the end
     * @param description the description
     * @param filePath the file path
     */
    public LotDTO(Long id, Long buyerId, Long ownerId, Long flowerId, Long addressId, BigDecimal startPrice, BigDecimal currentPrice, LotState state, int count, LocalDateTime end, String description, String filePath) {
        this.id = id;
        this.buyerId = buyerId;
        this.ownerId = ownerId;
        this.flowerId = flowerId;
        this.addressId = addressId;
        this.startPrice = startPrice;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
        this.end = end;
        this.description = description;
        this.filePath = filePath;
    }

    /**
     * Instantiates a new lot DTO.
     */
    public LotDTO() {
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
     * Gets the buyer id.
     *
     * @return the buyer id
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * Sets the buyer id.
     *
     * @param buyerId the new buyer id
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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
     * Gets the address id.
     *
     * @return the address id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Sets the address id.
     *
     * @param addressId the new address id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the start price.
     *
     * @return the start price
     */
    public BigDecimal getStartPrice() {
        return startPrice;
    }

    /**
     * Sets the start price.
     *
     * @param startPrice the new start price
     */
    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotDTO lotDTO = (LotDTO) o;
        return count == lotDTO.count &&
                Objects.equals(id, lotDTO.id) &&
                Objects.equals(buyerId, lotDTO.buyerId) &&
                Objects.equals(ownerId, lotDTO.ownerId) &&
                Objects.equals(flowerId, lotDTO.flowerId) &&
                Objects.equals(addressId, lotDTO.addressId) &&
                Objects.equals(startPrice, lotDTO.startPrice) &&
                Objects.equals(currentPrice, lotDTO.currentPrice) &&
                state == lotDTO.state &&
                Objects.equals(end, lotDTO.end) &&
                Objects.equals(description, lotDTO.description) &&
                Objects.equals(filePath, lotDTO.filePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, buyerId, ownerId, flowerId, addressId, startPrice, currentPrice, state, count, end, description, filePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "LotDTO{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", ownerId=" + ownerId +
                ", flowerId=" + flowerId +
                ", addressId=" + addressId +
                ", startPrice=" + startPrice +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                ", end=" + end +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
