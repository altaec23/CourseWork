package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alekseev.a
 * @since 1.0
 */
class QueueTest {

    @Test
    void enqueueTest() {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(1, queue.getFirstObject());

        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(5, queue.getLastObject());
    }

    @Test
    void dequeueTest() {
        Queue queue = new Queue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();

        assertEquals(2, queue.top());
    }

    @Test
    void emptyTest() {
        Queue queue = new Queue(3);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());
    }

}
