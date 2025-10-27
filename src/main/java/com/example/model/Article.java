package com.example.model;

import com.example.Calculator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
    private String name;
    private int quantity;
    
    @JsonProperty("unitPrice")
    private double price;
    private double discount; // en porcentaje (0–100)

    private Calculator calculator = new Calculator();

    public Article() {
    }

    public Article(String name, int quantity, double price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // importe bruto = cantidad * precio
    public double getGrossAmount() {
        return quantity * price;
    }

    // importe con descuento
    public double getDiscountedAmount() {
        double gross = getGrossAmount();
        return calculator.discount(gross, discount);
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
