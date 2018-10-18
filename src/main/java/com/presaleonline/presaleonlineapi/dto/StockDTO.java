package com.presaleonline.presaleonlineapi.dto;

public class StockDTO {

    private String articleCode;
    private String articleName;
    private double quantity;
    private double idealQuantity;
    private double minQuantity;


    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
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
