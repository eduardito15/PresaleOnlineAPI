package com.presaleonline.presaleonlineapi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class StockItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Article article;

    @Column
    private double quantity;

    @Column
    private double idealQuantity;

    @Column
    private double minQuantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getIdealQuantity() {
        return idealQuantity;
    }

    public void setIdealQuantity(double idealQuantity) {
        this.idealQuantity = idealQuantity;
    }

    public double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(double minQuantity) {
        this.minQuantity = minQuantity;
    }
}
