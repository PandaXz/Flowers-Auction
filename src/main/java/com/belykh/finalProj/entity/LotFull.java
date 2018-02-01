package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.entity.dbo.LotState;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class LotFull {
    private Long id;
    private UserInfo buyer;
    private UserInfo owner;
    private FlowerDBO flower;
    private Address address;
    private BigDecimal startPrice;
    private BigDecimal currentPrice;
    private LotState state;
    private int count;
    private LocalDateTime end;
    private String description;

    public LotFull(Long id, UserInfo buyer, UserInfo owner, FlowerDBO flower, Address address, BigDecimal startPrice, BigDecimal currentPrice, LotState state, int count, LocalDateTime end, String description) {
        this.id = id;
        this.buyer = buyer;
        this.owner = owner;
        this.flower = flower;
        this.address = address;
        this.startPrice = startPrice;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
        this.end = end;
        this.description = description;
    }

    public LotFull() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getOwner() {
        return owner;
    }

    public void setOwner(UserInfo owner) {
        this.owner = owner;
    }

    public UserInfo getBuyer() {

        return buyer;
    }

    public void setBuyer(UserInfo buyer) {
        this.buyer = buyer;
    }

    public FlowerDBO getFlower() {
        return flower;
    }

    public void setFlower(FlowerDBO flower) {
        this.flower = flower;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "LotFull{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", owner=" + owner +
                ", flower=" + flower +
                ", address=" + address +
                ", startPrice=" + startPrice +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                ", end=" + end +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotFull lotFull = (LotFull) o;
        return count == lotFull.count &&
                Objects.equals(id, lotFull.id) &&
                Objects.equals(buyer, lotFull.buyer) &&
                Objects.equals(owner, lotFull.owner) &&
                Objects.equals(flower, lotFull.flower) &&
                Objects.equals(address, lotFull.address) &&
                Objects.equals(startPrice, lotFull.startPrice) &&
                Objects.equals(currentPrice, lotFull.currentPrice) &&
                state == lotFull.state &&
                Objects.equals(end, lotFull.end) &&
                Objects.equals(description, lotFull.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, buyer, owner, flower, address, startPrice, currentPrice, state, count, end, description);
    }
}
