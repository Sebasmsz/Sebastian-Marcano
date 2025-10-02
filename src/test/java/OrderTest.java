
//package com.example.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import com.example.model.Article;
import com.example.model.Order;

class OrderTest {

    @Test
    void testGrossTotal() {
        Article a1 = new Article("Laptop", 2, 500.0, 0.0); // 1000
        Article a2 = new Article("Phone", 1, 300.0, 0.0);  // 300
        Order order = new Order("001", Arrays.asList(a1, a2));

        assertEquals(1300.0, order.getGrossTotal(), 0.0001);
    }

    @Test
    void testDiscountedTotal() {
        Article a1 = new Article("Laptop", 2, 500.0, 10.0); // 1000 -> 900
        Article a2 = new Article("Phone", 1, 300.0, 50.0);  // 300 -> 150
        Order order = new Order("002", Arrays.asList(a1, a2));

        assertEquals(1050.0, order.getDiscountedTotal(), 0.0001);
    }

    @Test
    void testEmptyOrderTotalsZero() {
        Order order = new Order("003", Arrays.asList());
        assertEquals(0.0, order.getGrossTotal(), 0.0001);
        assertEquals(0.0, order.getDiscountedTotal(), 0.0001);
    }
}

