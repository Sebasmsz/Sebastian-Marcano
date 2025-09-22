import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Calculator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CalculatorTests {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("multiply: multiplicación normal")
    void testMultiplyNormal() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @DisplayName("multiply: multiplicación con cero")
    void testMultiplyWithZero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    @DisplayName("multiply: multiplicación con negativos")
    void testMultiplyWithNegatives() {
        assertEquals(-12, calculator.multiply(-3, 4));
    }

    @Test
    @DisplayName("concat: concatenación normal")
    void testConcatNormal() {
        assertEquals("hello world", calculator.concat("hello ", "world"));
    }

    @Test
    @DisplayName("concat: parámetro null devuelve 'empty'")
    void testConcatWithNull() {
        assertEquals("empty", calculator.concat(null, "test"));
        assertEquals("empty", calculator.concat("hello", null));
    }

    @Test
    @DisplayName("sum: suma normal")
    void testSumNormal() {
        assertEquals(7.5, calculator.sum(3.2, 4.3), 0.0001);
    }

    @Test
    @DisplayName("sum: suma con negativos")
    void testSumWithNegatives() {
        assertEquals(-1.0, calculator.sum(3, -4), 0.0001);
    }

    @Test
    @DisplayName("discount: aplica descuento válido")
    void testDiscountValid() {
        assertEquals(80.0, calculator.discount(100.0, 20.0), 0.0001);
    }

    @Test
    @DisplayName("discount: 0% y 100%")
    void testDiscountEdgeCases() {
        assertEquals(100.0, calculator.discount(100.0, 0.0), 0.0001);
        assertEquals(0.0, calculator.discount(100.0, 100.0), 0.0001);
    }

    @Test
    @DisplayName("discount: porcentaje inválido lanza excepción")
    void testDiscountInvalidPercent() {
        assertThrows(IllegalArgumentException.class, () -> calculator.discount(100.0, -5));
        assertThrows(IllegalArgumentException.class, () -> calculator.discount(100.0, 150));
    }

    @Test
    @DisplayName("calculateTotal: suma correcta")
    void testCalculateTotal() {
        List<Double> amounts = Arrays.asList(10.0, 20.0, 30.0);
        assertEquals(60.0, calculator.calculateTotal(amounts), 0.0001);
    }

    @Test
    @DisplayName("calculateTotal: lista vacía devuelve 0.0")
    void testCalculateTotalEmpty() {
        assertEquals(0.0, calculator.calculateTotal(Collections.emptyList()), 0.0001);
    }
}
