package com.example.view;

import javax.swing.*;
import com.example.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {
        setAppIcon();
        setTitle("Order Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Order ID:"));
        add(searchField);
        add(searchButton);
        add(new JScrollPane(resultArea));

        resultArea.setEditable(false);
        pack();
        setVisible(true);
    }

    public String getSearchId() {
        return searchField.getText();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayOrder(Order order, double rate) {
    double grossTotal = order.getGrossTotal();
    double discountedTotal = order.getDiscountedTotal();
    double totalUSD = discountedTotal * rate;

    StringBuilder sb = new StringBuilder();
    sb.append("Order ID: ").append(order.getId()).append("\n\n");
    
    sb.append("Totales\n");
    sb.append("Gross Total (EUR): ").append(grossTotal).append("\n");
    sb.append("Discounted Total (EUR): ").append(discountedTotal).append("\n");
    sb.append("Exchange Rate EUR → USD: ").append(rate).append("\n");
    sb.append("Discounted Total (USD): ").append(totalUSD).append("\n\n");

    sb.append("Articles\n");
    order.getArticles().forEach(article -> {
        sb.append(" - ").append(article.getName())
          .append(" x").append(article.getQuantity())
          .append(" (gross: ").append(article.getGrossAmount()).append(")")
          .append("\n");
    });

    resultArea.setText(sb.toString());
}

    public void displayMessage(String message) {
        resultArea.setText(message);
    }

    private void setAppIcon() {
    try {
        java.net.URL iconURL = getClass().getResource("/app.png");
        if (iconURL != null) {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(iconURL);
            setIconImage(icon.getImage());
        }
    } catch (Exception e) {
        System.err.println("No se pudo cargar el icono: " + e.getMessage());
    }
}
}

