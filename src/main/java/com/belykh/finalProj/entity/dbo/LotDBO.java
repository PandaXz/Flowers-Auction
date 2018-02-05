package com.belykh.finalProj.entity.dbo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by panda on 7.1.18.
 */
public class LotDBO {
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

    public LotDBO(Long id, Long buyerId, Long ownerId, Long flowerId, Long addressId, BigDecimal startPrice, BigDecimal currentPrice, LotState state, int count, LocalDateTime end, String description, String filePath) {
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

    public LotDBO() {
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public LotState getState() {
        return state;
    }

    public void setState(LotState state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
        LotDBO lotDBO = (LotDBO) o;
        return count == lotDBO.count &&
                Objects.equals(id, lotDBO.id) &&
                Objects.equals(buyerId, lotDBO.buyerId) &&
                Objects.equals(ownerId, lotDBO.ownerId) &&
                Objects.equals(flowerId, lotDBO.flowerId) &&
                Objects.equals(addressId, lotDBO.addressId) &&
                Objects.equals(startPrice, lotDBO.startPrice) &&
                Objects.equals(currentPrice, lotDBO.currentPrice) &&
                state == lotDBO.state &&
                Objects.equals(end, lotDBO.end) &&
                Objects.equals(description, lotDBO.description) &&
                Objects.equals(filePath, lotDBO.filePath);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, buyerId, ownerId, flowerId, addressId, startPrice, currentPrice, state, count, end, description, filePath);
    }

    @Override
    public String toString() {
        return "LotDBO{" +
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
