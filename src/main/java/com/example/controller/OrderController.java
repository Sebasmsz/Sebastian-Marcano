package com.example.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.model.Order;
import com.example.Searcher;
import com.example.view.OrderView;

public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderView view;
    private List<Order> orders;
    private Searcher searcher;

    public OrderController(OrderView view, List<Order> orders) {
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();

        // Escuchar el botón de búsqueda
        view.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchOrder();
            }
        });
    }

    private void searchOrder() {
        String id = view.getSearchId().trim();
        if (id.isEmpty()) {
            view.displayMessage("Please enter an order ID.");
            return;
        }

        log.info("Buscando pedido con ID: {}", id);
        Order foundOrder = searcher.findById(orders, id);

        if (foundOrder != null) {
            log.info("Pedido encontrado: {}", foundOrder.getId());
            view.displayOrder(foundOrder, 1.0);
        } else {
            log.warn("Pedido no encontrado con ID: {}", id);
            view.displayMessage("Pedido no encontrado con ID: " + id);
        }
    }
}