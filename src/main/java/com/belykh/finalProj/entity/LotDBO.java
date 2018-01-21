package com.belykh.finalProj.entity;

/**
 * Created by panda on 7.1.18.
 */
public class LotDBO {
    private Long id;
    private Long buyerId;
    private Long auctionId;
    private Long ownerId;
    private Long flowerId;
    private Long addressId;
    private Double startPrice;
    private Double currentPrice;
    private LotState state;
    private int count;
    private String description;

    public LotDBO(Long id, Long buyerId, Long auctionId, Long ownerId, Long flowerId, Long addressId, Double startPrice, Double currentPrice, LotState state, int count, String description) {
        this.id = id;
        this.buyerId = buyerId;
        this.auctionId = auctionId;
        this.ownerId = ownerId;
        this.flowerId = flowerId;
        this.addressId = addressId;
        this.startPrice = startPrice;
        this.currentPrice = currentPrice;
        this.state = state;
        this.count = count;
        this.description = description;
    }

    public LotDBO() {
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

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
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

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
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

        if (state != lotDBO.state) return false;
        if (count != lotDBO.count) return false;
        if (!id.equals(lotDBO.id)) return false;
        if (buyerId != null ? !buyerId.equals(lotDBO.buyerId) : lotDBO.buyerId != null) return false;
        if (!auctionId.equals(lotDBO.auctionId)) return false;
        if (!ownerId.equals(lotDBO.ownerId)) return false;
        if (!flowerId.equals(lotDBO.flowerId)) return false;
        if (!addressId.equals(lotDBO.addressId)) return false;
        if (!startPrice.equals(lotDBO.startPrice)) return false;
        if (!currentPrice.equals(lotDBO.currentPrice)) return false;
        return description.equals(lotDBO.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (buyerId != null ? buyerId.hashCode() : 0);
        result = 31 * result + auctionId.hashCode();
        result = 31 * result + ownerId.hashCode();
        result = 31 * result + flowerId.hashCode();
        result = 31 * result + addressId.hashCode();
        result = 31 * result + startPrice.hashCode();
        result = 31 * result + currentPrice.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + count;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LotDBO{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", auctionId=" + auctionId +
                ", ownerId=" + ownerId +
                ", flowerId=" + flowerId +
                ", addressId=" + addressId +
                ", startPrice=" + startPrice +
                ", currentPrice=" + currentPrice +
                ", state=" + state +
                ", count=" + count +
                ", description='" + description + '\'' +
                '}';
    }
}
