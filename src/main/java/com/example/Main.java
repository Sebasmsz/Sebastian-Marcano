package com.example;

import com.example.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Starting Order Management System...");

        List<Order> orders = loadOrdersFromJson("/orders.json");

        log.info("Pedidos cargados correctamente: {}", orders.size());
        for (Order order : orders) {
            log.debug("Loaded order: {}", order.getId());
            log.info("Order {} -> Total bruto: {}, Total con descuento: {}",
                    order.getId(),
                    order.getGrossTotal(),
                    order.getDiscountedTotal());
        }

        com.example.view.OrderView view = new com.example.view.OrderView();
    new com.example.controller.OrderController(view, orders);
    }

    public static List<Order> loadOrdersFromJson(String resourcePath) {
        ObjectMapper mapper = new ObjectMapper();
        List<Order> orders = List.of();

        try (InputStream inputStream = Main.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                log.error("No se encontró el fichero {}", resourcePath);
                return orders;
            }

            orders = mapper.readValue(inputStream, new TypeReference<>() {});
            log.info("Fichero JSON leído correctamente: {}", resourcePath);

        } catch (Exception e) {
            log.error("Error al leer o parsear el fichero JSON: {}", e.getMessage());
        }

        return orders;
    }
}