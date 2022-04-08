package alekseev;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Класс для подсчёта частоты появлений слов в тексте
 *
 * @author alekseev.a
 * @since 1.0
 */
public class FindEqualsWord {

    /**
     * Метод возвращает массив из 10 отсортированных по частоте повторений слов в тексте,
     * игнорируя регистр слов и разбивая текст по "пробелу"
     *
     * @param text входной текст
     * @return сортированный массив
     */
    public static String[] getRankingWord(String text) {
        return Arrays.stream(text.toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(10)
                .map(Map.Entry::getKey).toArray(String[]::new);
    }
}
