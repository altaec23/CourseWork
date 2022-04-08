package core;

import java.util.*;

/**
 * Класс для преобразования двумерного массива в одномерный с использованием механизма Generics
 *
 * @author alekseev.a
 * @since 1.0
 */
public class ArrayIterator<E> implements Iterator<E> {
    private final E[] array;
    private int index;

    public ArrayIterator(E[][] array) {
        this.array = convertArray(array);
        index = 0;
    }

    /**
     * Метод конвертации двумерного массива, к одномерному
     *
     * @param array двумерный массив с типом generics
     * @return одномерный массив с типом generics
     */
    private E[] convertArray(E[][] array) {
        final List<E> arrayList = new ArrayList<>();
        for (E[] arrays : array) {
            arrayList.addAll(Arrays.asList(arrays));
        }
        return (E[]) arrayList.toArray();
    }

    /**
     * Метод возвращающий наличие следующиего элемента
     *
     * @return возвращает true или false
     */
    @Override
    public boolean hasNext() {
        return index != array.length;
    }

    /**
     * Метод возвращает следующий элемент массива
     *
     * @return элемент массива
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[index++];
    }
}
