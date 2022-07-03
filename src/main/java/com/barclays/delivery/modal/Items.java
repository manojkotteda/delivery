package com.barclays.delivery.modal;

public class Items {
    private String name;
    private Integer mrp;
    private Integer discountPercent;
    private Integer availableQuantity;
    private Integer discountedSellingPrice;
    private Integer weightInGms;
    private Boolean outOfStock;
    private Integer quantity;

    public Items() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMrp() {
        return mrp;
    }

    public void setMrp(Integer mrp) {
        this.mrp = mrp;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getDiscountedSellingPrice() {
        return discountedSellingPrice;
    }

    public void setDiscountedSellingPrice(Integer discountedSellingPrice) {
        this.discountedSellingPrice = discountedSellingPrice;
    }

    public Integer getWeightInGms() {
        return weightInGms;
    }

    public void setWeightInGms(Integer weightInGms) {
        this.weightInGms = weightInGms;
    }

    public Boolean getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(Boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
