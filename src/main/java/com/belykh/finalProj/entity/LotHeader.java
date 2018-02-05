package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.LotState;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(Long flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

    @Override
    public int hashCode() {

        return Objects.hash(id, flowerId, flowerName, ownerId, owner, currentPrice, state, count, end, filePath);
    }

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
