package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест класс для демонстации и проверки статусов потока.
 * sleep главного потока используется для "микро-остановки" чтобы статус у запущенного внутри теста thread был верен
 *
 * @author alekseev.a
 * @since 1.0
 */
class TestTask10 {

    /**
     * Тест на состояние потока "NEW"
     */
    @Test
    void testNewStateThread() {
        Thread thread = new Thread(() -> {
        });
        assertEquals(Thread.State.NEW, thread.getState());
    }

    /**
     * Тест на состояние потока "RUNNABLE"
     */
    @Test
    void testRunnableStateThread() {
        Thread thread = new Thread(() -> System.out.println("Run thread..."));
        thread.start();
        assertEquals(Thread.State.RUNNABLE, thread.getState());
    }

    /**
     * Тест на состояние потока Waiting
     */
    @Test
    void testWaitingStateThread() throws InterruptedException {
        var tskObj = new Task10UtilMethods();
        Thread thread = new Thread(tskObj::waitingMethod);
        thread.start();
        Thread.sleep(70);
        assertEquals(Thread.State.WAITING, thread.getState());
    }

    /**
     * Тест на проверку состояния потока TIMED_WAITING
     */
    @Test
    void testWaitingTimeStateThread() throws InterruptedException {
        var tskObj = new Task10UtilMethods();
        Thread thread = new Thread(tskObj::timeWaitingMethod);
        thread.start();
        Thread.sleep(70);
        assertEquals(Thread.State.TIMED_WAITING, thread.getState());
    }

    /**
     * Тест на проверку состояния потока BLOCKED
     */
    @Test
    void testBlockedStateThread() throws InterruptedException {
        var tskObj = new Task10UtilMethods();
        Thread thread = new Thread(() -> {
            tskObj.blockedMethod();
            System.out.println("Invoke methode thread 1...");
        });
        Thread thread2 = new Thread(() -> {
            tskObj.blockedMethod();
            System.out.println("Invoke methode thread 2...");
        });

        thread.start();
        thread2.start();
        Thread.sleep(400);
        assertEquals(Thread.State.BLOCKED, thread2.getState());
    }

    /**
     * Тест на проверку состояния потока TERMINATED
     */
    @Test
    void testTerminatedStateThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        thread.join();
        assertEquals(Thread.State.TERMINATED, thread.getState());
    }

}
