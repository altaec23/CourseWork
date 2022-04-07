package core;

/**
 * Класс реализующий очередь
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Queue extends BaseDataStructures {
    /**
     * Конструктор класса очереди
     *
     * @param sizeQueue размер очереди
     */
    public Queue(int sizeQueue) {
        super(sizeQueue);

    }

    /**
     * Метод добавления элемента в конец очереди
     */
    public void enqueue(Object object) {
        addElement(object);
    }

    /**
     * Метод удаления элемента из начала очереди
     */
    public void dequeue() {
        deleteFirstElement();
    }

    /**
     * Метод возвращения первого элемент очереди
     */
    public Object top() {
       return getFirstObject();
    }

}
