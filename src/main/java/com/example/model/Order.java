package com.example.model;

import java.util.List;

public class Order {
    private String id;
    private List<Article> articles;

    public Order(String id, List<Article> articles) {
        this.id = id;
        this.articles = articles;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    // total bruto de todos los artículos
    public double getGrossTotal() {
        return articles.stream()
                .mapToDouble(Article::getGrossAmount)
                .sum();
    }

    // total con descuento aplicado
    public double getDiscountedTotal() {
        return articles.stream()
                .mapToDouble(Article::getDiscountedAmount)
                .sum();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", articles=" + articles +
                '}';
    }
}
