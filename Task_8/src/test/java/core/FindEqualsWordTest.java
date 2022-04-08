package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author alekseev.a
 * @since 1.0
 */
class FindEqualsWordTest {

    /**
     * Тест на простую проверку поиска одних и тех же слов в ранжировании.
     */
    @Test
    void simpleEqualsWordTest() {
        String text = "mY name’s David. We’re in a small village near Chicago. My cousin’s getting married. " +
                "My father and her father are twins. A lot of relatives ARE here for the wedding party. Were very busy." +
                " MY uncle’s friend is making palov. My sister Susan and Aunt Keane arE making cakes. " +
                "my mother’s helping her niece with her wedding dress. My grandparEnts are too. They’re very old. " +
                "They live in Chicago. I’m making a video and taking photos. It’s very great. I want to be and A reporter.";

        String[] template = {"my", "are", "and", "a", "very", "her", "making", "in", "father", "wedding"};
        assertArrayEquals(template, alekseev.FindEqualsWord.getRankingWord(text));
    }

    /**
     * Тест на корректность работы вместе с символами и цифрами
     */
    @Test
    void smallWordTest() {
        String text = "1mY names - 1 David.  2     1 Were Chicago. 1mY - names - David. ! weRE Chicago.  2  ";

        String[] template = {"-", "1", "2", "names", "were", "david.", "1my", "chicago.", "!"};
        assertArrayEquals(template, alekseev.FindEqualsWord.getRankingWord(text));
    }

}
