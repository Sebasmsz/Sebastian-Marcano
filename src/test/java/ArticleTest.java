

import org.junit.jupiter.api.Test;

import com.example.model.Article;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void testGrossAmount() {
        Article article = new Article("Laptop", 2, 500.0, 0.0);
        assertEquals(1000.0, article.getGrossAmount(), 0.0001);
    }

    @Test
    void testDiscountedAmount() {
        Article article = new Article("Laptop", 2, 500.0, 10.0);
        assertEquals(900.0, article.getDiscountedAmount(), 0.0001);
    }

    @Test
    void testDiscountedAmountWithZeroPercent() {
        Article article = new Article("Phone", 1, 300.0, 0.0);
        assertEquals(300.0, article.getDiscountedAmount(), 0.0001);
    }

    @Test
    void testDiscountedAmountWithHundredPercent() {
        Article article = new Article("Phone", 1, 300.0, 100.0);
        assertEquals(0.0, article.getDiscountedAmount(), 0.0001);
    }
}
