package com.belykh.finalProj.entity;

import com.belykh.finalProj.entity.dbo.FlowerDBO;
import com.belykh.finalProj.entity.dbo.LotState;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class LotFull.
 */
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
    private String imagePath;

    /**
     * Instantiates a new lot full.
     *
     * @param id the id
     * @param buyer the buyer
     * @param owner the owner
     * @param flower the flower
     * @param address the address
     * @param startPrice the start price
     * @param currentPrice the current price
     * @param state the state
     * @param count the count
     * @param end the end
     * @param description the description
     * @param filePath the file path
     */
    public LotFull(Long id, UserInfo buyer, UserInfo owner, FlowerDBO flower, Address address, BigDecimal startPrice, BigDecimal currentPrice, LotState state, int count, LocalDateTime end, String description, String filePath) {
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
        this.imagePath = filePath;
    }

    /**
     * Gets the image path.
     *
     * @return the image path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the image path.
     *
     * @param filePath the new image path
     */
    public void setImagePath(String filePath) {
        this.imagePath = filePath;
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
     * Gets the owner.
     *
     * @return the owner
     */
    public UserInfo getOwner() {
        return owner;
    }

    /**
     * Sets the owner.
     *
     * @param owner the new owner
     */
    public void setOwner(UserInfo owner) {
        this.owner = owner;
    }

    /**
     * Gets the buyer.
     *
     * @return the buyer
     */
    public UserInfo getBuyer() {

        return buyer;
    }

    /**
     * Sets the buyer.
     *
     * @param buyer the new buyer
     */
    public void setBuyer(UserInfo buyer) {
        this.buyer = buyer;
    }

    /**
     * Gets the flower.
     *
     * @return the flower
     */
    public FlowerDBO getFlower() {
        return flower;
    }

    /**
     * Sets the flower.
     *
     * @param flower the new flower
     */
    public void setFlower(FlowerDBO flower) {
        this.flower = flower;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(Address address) {
        this.address = address;
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
                Objects.equals(description, lotFull.description) &&
                Objects.equals(imagePath, lotFull.imagePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        return Objects.hash(id, buyer, owner, flower, address, startPrice, currentPrice, state, count, end, description, imagePath);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
                ", imagePath='" + imagePath + '\'' +
                '}';
    }

}
