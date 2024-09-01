package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchases")
@SuppressWarnings("unused")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private String paymentMethod;

    private String comments;

    private String status;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private Set<ProductsPurchases> productsPurchases = new HashSet<>();

    public Purchase() {
    }

    public Purchase(Long id, LocalDateTime date, String paymentMethod, String comments, String status, Client client, Set<ProductsPurchases> productsPurchases) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.comments = comments;
        this.status = status;
        this.client = client;
        this.productsPurchases = productsPurchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
