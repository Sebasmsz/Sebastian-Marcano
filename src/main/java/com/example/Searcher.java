package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Order;

/**
 * Searcher utility class for search operations on String lists and Orders.
 */
public class Searcher {

    // Métodos de búsqueda para cadenas
    public boolean searchExactPhrase(String phrase, List<String> list) {
        for (String item : list) {
            if (item.equals(phrase)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchWord(String word, List<String> list) {
        return list.contains(word);
    }

    public String getWordByIndex(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    public List<String> searchByPrefix(String prefix, List<String> list) {
        List<String> results = new ArrayList<>();
        for (String element : list) {
            if (element.startsWith(prefix)) {
                results.add(element);
            }
        }
        return results;
    }

    public List<String> filterByKeyword(String keyword, List<String> list) {
        List<String> results = new ArrayList<>();
        for (String element : list) {
            if (element.contains(keyword)) {
                results.add(element);
            }
        }
        return results;
    }

    public Order findById(List<Order> orders, String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order;
            }
        }
        return null;
    }
}
