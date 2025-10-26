package com.example;

import com.example.model.Article;
import com.example.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Starting Order Management System...");

        String filePath = "orders.txt"; // Ruta del fichero a leer
        List<Order> orders = parseOrdersFile(filePath);

        log.info("Pedidos cargados correctamente: {}", orders.size());
        for (Order order : orders) {
            log.info("Order {} -> Total bruto: {}, Total con descuento: {}",
                    order.getId(),
                    order.getGrossTotal(),
                    order.getDiscountedTotal());
        }
    }

    public static List<Order> parseOrdersFile(String filePath) {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Order currentOrder = null;
            List<Article> currentArticles = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) continue; // saltar líneas vacías

                if (line.startsWith("Order:")) {
                    // Si había un pedido previo, guardarlo antes de comenzar el nuevo
                    if (currentOrder != null) {
                        currentOrder.setArticles(currentArticles);
                        orders.add(currentOrder);
                        log.debug("Loaded order: {}", currentOrder.getId());
                        currentArticles = new ArrayList<>();
                    }

                    String orderId = line.substring("Order:".length()).trim();
                    currentOrder = new Order();
                    currentOrder.setId(orderId);

                } else if (line.startsWith("Article:")) {
                    String[] parts = line.substring("Article:".length()).trim().split(",");
                    if (parts.length == 4) {
                        String name = parts[0].trim();
                        int quantity = Integer.parseInt(parts[1].trim());
                        double price = Double.parseDouble(parts[2].trim());
                        double discount = Double.parseDouble(parts[3].trim());
                        currentArticles.add(new Article(name, quantity, price, discount));
                    } else {
                        log.warn("Formato inválido en línea: {}", line);
                    }
                }
            }

            // guardar el último pedido leído
            if (currentOrder != null) {
                currentOrder.setArticles(currentArticles);
                orders.add(currentOrder);
                log.debug("Loaded order: {}", currentOrder.getId());
            }

        } catch (IOException e) {
            log.error("Error al leer el fichero de pedidos: {}", e.getMessage());
        }

        return orders;
    }
}