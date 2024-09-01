package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@SuppressWarnings("unused")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String barcode;

    private Double salePrice;

    private Integer stock;

    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductsPurchases> productsPurchases = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String barcode, Double salePrice, Integer stock, Boolean status, Category category, Set<ProductsPurchases> productsPurchases) {
        this.id = id;
        this.name = name;
        this.barcode = barcode;
        this.salePrice = salePrice;
        this.stock = stock;
        this.status = status;
        this.category = category;
        this.productsPurchases = productsPurchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
