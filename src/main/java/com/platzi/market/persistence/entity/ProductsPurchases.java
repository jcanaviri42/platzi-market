package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products_purchases")
@SuppressWarnings("unused")
public class ProductsPurchases {

    @EmbeddedId
    private ProductsPurchasesId id;

    private Integer quantity;

    private Double total;

    private Boolean status;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "purchase_id", insertable = false, updatable = false)
    private Purchase purchase;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    public ProductsPurchases() {
    }

    public ProductsPurchases(ProductsPurchasesId id, Integer quantity, Double total, Boolean status, Purchase purchase, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.purchase = purchase;
        this.product = product;
    }

    public ProductsPurchasesId getId() {
        return id;
    }

    public void setId(ProductsPurchasesId id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
