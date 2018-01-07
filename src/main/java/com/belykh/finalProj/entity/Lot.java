package com.belykh.finalProj.entity;

/**
 * Created by panda on 7.1.18.
 */
public class Lot {
    private Long id;
    private User buyer;
    private Auction auction;
    private User owner;
    private Flower flower;
    private Address address;
    private Long startPrice;
    private Long currentPrice;
    private int state;
    private int count;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Long startPrice) {
        this.startPrice = startPrice;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Long currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
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

        Lot lot = (Lot) o;

        if (state != lot.state) return false;
        if (count != lot.count) return false;
        if (!id.equals(lot.id)) return false;
        if (buyer != null ? !buyer.equals(lot.buyer) : lot.buyer != null) return false;
        if (!auction.equals(lot.auction)) return false;
        if (!owner.equals(lot.owner)) return false;
        if (!flower.equals(lot.flower)) return false;
        if (!address.equals(lot.address)) return false;
        if (!startPrice.equals(lot.startPrice)) return false;
        if (!currentPrice.equals(lot.currentPrice)) return false;
        return description.equals(lot.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + auction.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + flower.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + startPrice.hashCode();
        result = 31 * result + currentPrice.hashCode();
        result = 31 * result + state;
        result = 31 * result + count;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", auction=" + auction +
                ", owner=" + owner +
                ", flower=" + flower +
                ", address=" + address +
                ", startPrice=" + startPrice +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                ", description='" + description + '\'' +
                '}';
    }
}
