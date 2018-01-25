package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.LotState;

import java.util.Objects;

public class LotHeader {
    private Long id;
    private Long flowerId;
    private String flowerName;
    private Double currentPrice;
    private LotState state;
    private int count;

    public LotHeader(Long id, Long flowerId, String flowerName, Double currentPrice, LotState state, int count) {
        this.id = id;
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
    }

    public LotHeader() {
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
                Objects.equals(currentPrice, lotHeader.currentPrice) &&
                state == lotHeader.state;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, flowerId, flowerName, currentPrice, state, count);
    }

    @Override
    public String toString() {
        return "LotHeader{" +
                "id=" + id +
                ", flowerId=" + flowerId +
                ", flowerName='" + flowerName + '\'' +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                '}';
    }
}
