package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@SuppressWarnings("unused")
public class ProductsPurchasesId implements Serializable {

    @Column(name = "purchase_id")
    private Long purchaseId;

    @Column(name = "product_id")
    private Long productId;

    public ProductsPurchasesId() {
    }

    public ProductsPurchasesId(Long productId, Long purchaseId) {
        this.productId = productId;
        this.purchaseId = purchaseId;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsPurchasesId that = (ProductsPurchasesId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(purchaseId, that.purchaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purchaseId);
    }
}
