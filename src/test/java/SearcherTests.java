import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Searcher;

import java.util.Arrays;
import java.util.List;

public class SearcherTests {

    Searcher searcher;
    List<String> sampleList;

    @BeforeEach
    void setUp() {
        searcher = new Searcher();
        sampleList = Arrays.asList("apple", "banana", "apricot", "grape", "pineapple");
    }

    @Test
    @DisplayName("searchWord: palabra existe en la lista")
    void testSearchWordExists() {
        assertTrue(searcher.searchWord("banana", sampleList));
    }

    @Test
    @DisplayName("searchWord: palabra no existe en la lista")
    void testSearchWordNotExists() {
        assertFalse(searcher.searchWord("orange", sampleList));
    }

    @Test
    @DisplayName("getWordByIndex: índice válido devuelve palabra correcta")
    void testGetWordByIndexValid() {
        assertEquals("apple", searcher.getWordByIndex(sampleList, 0));
        assertEquals("grape", searcher.getWordByIndex(sampleList, 3));
    }

    @Test
    @DisplayName("getWordByIndex: índice inválido devuelve null")
    void testGetWordByIndexInvalid() {
        assertNull(searcher.getWordByIndex(sampleList, -1));
        assertNull(searcher.getWordByIndex(sampleList, 99));
    }

    @Test
    @DisplayName("searchByPrefix: devuelve palabras con prefijo 'ap'")
    void testSearchByPrefix() {
        List<String> result = searcher.searchByPrefix("ap", sampleList);
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("apricot"));
        assertFalse(result.contains("banana"));
    }

    @Test
    @DisplayName("filterByKeyword: devuelve elementos que contienen keyword")
    void testFilterByKeyword() {
        List<String> result = searcher.filterByKeyword("apple", sampleList);
        assertTrue(result.contains("apple"));
        assertTrue(result.contains("pineapple"));
    }

    @Test
    @DisplayName("filterByKeyword: keyword inexistente devuelve lista vacía")
    void testFilterByKeywordNotFound() {
        List<String> result = searcher.filterByKeyword("pear", sampleList);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("searchExactPhrase: BUG - solo funciona si frase está al inicio")
    void testSearchExactPhraseBug() {
        List<String> list = Arrays.asList("orange", "big banana", "small apple");
        assertTrue(searcher.searchExactPhrase("orange", list)); // ✅ funciona
        assertTrue(searcher.searchExactPhrase("big banana", list)); // ⚠️ puede fallar según implementación
    }
}

