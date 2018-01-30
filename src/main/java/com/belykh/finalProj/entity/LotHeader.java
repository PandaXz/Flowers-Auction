package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.LotState;

import java.time.LocalDateTime;
import java.util.Objects;

public class LotHeader {
    private Long id;
    private Long flowerId;
    private String flowerName;
    private Long ownerId;
    private String owner;
    private Double currentPrice;
    private LotState state;
    private int count;
    private LocalDateTime end;

    public LotHeader(Long id, Long flowerId, String flowerName, Long ownerId, String owner, Double currentPrice, LotState state, int count, LocalDateTime end) {
        this.id = id;
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.ownerId = ownerId;
        this.owner = owner;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
        this.end = end;
    }

    public LotHeader() {
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
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
                Objects.equals(end, lotHeader.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, flowerId, flowerName, ownerId, owner, currentPrice, state, count, end);
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
                '}';
    }
}
