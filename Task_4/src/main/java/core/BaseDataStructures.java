package core;

import java.util.Arrays;

/**
 * Базовый класс для представления данных и методов Stack и Queue
 *
 * @author alekseev.a
 * @since 1.0
 */
public class BaseDataStructures {

    private final Object[] arrayObject;
    private int arrayIndex;

    /**
     * Конструктор класса с максимальным размером массива данных
     *
     * @param size размер массива
     */
    protected BaseDataStructures(int size) {
        arrayObject = new Object[size];
        arrayIndex = 0;
    }

    /**
     * Метод добавлящию объект в ячейку памяти
     *
     * @param object добавляемый объект
     */
    public void addElement(Object object) {
        try {
            arrayObject[arrayIndex] = object;
            arrayIndex++;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Указан недопустимый индекс при добавлении элемента" + ex);
        }

    }

    /**
     * метод удаления последнего объекта в массиве данных
     *
     * @return удаляемый объект
     */
    public Object deletedLastElement() {
        try {
            var popObject = arrayObject[arrayIndex - 1];
            arrayObject[arrayIndex - 1] = null;
            arrayIndex--;
            return popObject;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Указан недопустимый индекс при удалении последнего элемента" + ex);
        }
        return null;
    }

    /**
     * Метод удаления первого объекта
     */
    public void deleteFirstElement() {
        try {
            arrayObject[0] = null;
            System.arraycopy(arrayObject, 1, arrayObject, 0, arrayIndex);
            arrayIndex--;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Указан недопустимый индекс при удалении первого элемента" + ex);
        }
    }

    /**
     * Метод получения первого объекта в массиве данных
     *
     * @return первый объект
     */
    public Object getFirstObject() {
        return arrayObject[0];
    }

    /**
     * Метод получения последнего объекта в массиве данных
     *
     * @return последний объект
     */
    public Object getLastObject() {
        return arrayObject[arrayIndex == 0 ? arrayIndex : arrayIndex - 1];
    }

    /**
     * Метод проверки массива на наличие объектов
     *
     * @return true или false
     */
    public boolean isEmpty() {
        return arrayIndex == 0;
    }

    @Override
    public String toString() {
        return "BaseDataStructures{" +
                "arrayObject=" + Arrays.toString(arrayObject) +
                '}';
    }
}
