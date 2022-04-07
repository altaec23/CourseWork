package core;

/**
 * Класс реализуюзий стэк
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Stack extends BaseDataStructures {

    /**
     * Конструктор стэка
     *
     * @param sizeStack размер стэка
     */
    public Stack(int sizeStack) {
        super(sizeStack);
    }

    /**
     * метод помещающий объект внутрь стэка
     *
     * @param object помещаемый объект
     */
    public void push(Object object) {
        addElement(object);
    }

    /**
     * Метод возвращающий верхний объект в стеке, после удаления
     *
     * @return если объекта нет в стеке, вернёт null
     */
    public Object pop() {
        return deletedLastElement();
    }

    /**
     * Метод возвращаюищй верхний объект в стеке, без удаления
     *
     * @return если объекта нет, вернётся null
     */
    public Object top() {
        return getLastObject();
    }
}
