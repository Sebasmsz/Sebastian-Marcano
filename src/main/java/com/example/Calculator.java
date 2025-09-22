package com.example;

import java.util.List;

/**
 * Calculator utility class with basic operations.
 */
public class Calculator {
	public static final String EMPTY = "empty";

	/**
	 * Multiply two integers.
	 * @param a first integer
	 * @param b second integer
	 * @return product of a and b
	 */
	public int multiply(int a, int b) {
		return a * b;
	}

	/**
	 * Concatenate two strings. Returns "empty" if either is null.
	 * @param a first string
	 * @param b second string
	 * @return concatenated string or "empty"
	 */
	public String concat(String a, String b) {
		if (a != null && b != null) {
			return a + b;
		}
		return EMPTY;
	}

	/**
	 * Add two double values.
	 * @param a first value
	 * @param b second value
	 * @return sum of a and b
	 */
	public double sum(double a, double b) {
		return a + b;
	}

	/**
	 * Apply a percentage discount to an amount.
	 * @param amount the original amount
	 * @param percent the discount percentage (0-100)
	 * @return discounted amount
	 * @throws IllegalArgumentException if percent is not between 0 and 100
	 */
	public double discount(double amount, double percent) {
		if (percent < 0 || percent > 100) {
			throw new IllegalArgumentException("Percentage must be between 0 and 100");
		}
		return amount - (amount * percent / 100.0);
	}

	/**
	 * Calculate the total sum of a list of amounts.
	 * @param amounts list of double values
	 * @return total sum
	 */
	public double calculateTotal(List<Double> amounts) {
		return amounts.stream().mapToDouble(Double::doubleValue).sum();
	}
}