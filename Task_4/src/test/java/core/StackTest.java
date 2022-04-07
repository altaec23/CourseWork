package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author alekseev.a
 * @since 1.0
 */
class StackTest {

    @Test
    void pushTest() {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.top());

        stack.push(3);
        stack.push(4);

        assertEquals(2, stack.top());
    }

    @Test
    void popTest() {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        stack.pop();

        assertEquals(1, stack.top());

        stack.pop();
        stack.pop();
        assertNull(stack.top());
    }

    @Test
    void emptyTest() {
        Stack stack = new Stack(5);
        assertTrue(stack.isEmpty());
    }


}
