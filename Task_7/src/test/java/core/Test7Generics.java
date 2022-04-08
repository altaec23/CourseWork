package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты на проверку правильности преобразования двумерного массива в одномерный, а также правильности обработки эксепшенов
 *
 * @author alekseev.a
 * @since 1.0
 */
class TestGen {
    private Double[][] doublesArray;

    @BeforeEach
    public void initArrayDouble() {
        doublesArray = new Double[7][7];
        var random = new Random();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                doublesArray[i][j] = random.nextDouble();
            }
        }
    }

    @Test
    void indexTest() {
        int count = 0;
        ArrayIterator<Double> doubleArrayIterator = new ArrayIterator<>(doublesArray);
        while (doubleArrayIterator.hasNext()) {
            doubleArrayIterator.next();
            count++;
        }
        assertEquals(49, count);
    }


    @Test
    void noSuchElementExceptionTest() {
        ArrayIterator<Double> doubleArrayIterator = new ArrayIterator<>(doublesArray);
        while (doubleArrayIterator.hasNext()) {
            doubleArrayIterator.next();
        }
        assertThrows(NoSuchElementException.class, doubleArrayIterator::next);
    }

}
