package core;

/**
 * Класс с методами synchronized для получения определенных статусов у потока за счет мьютекса.
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Task10UtilMethods {

    /**
     * Метод для получения состояния Thread.State.WAITING
     * Используем стандартный метод wait()
     */
    public synchronized void waitingMethod() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод с обычным ожиданием потока по времени, используется для демонстации статуса Thread.State.TIMED_WAITING
     */
    public void timeWaitingMethod() {
        try {
            Thread.sleep(4500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод который будет использован для демонстации состояния потока - Thread.State.BLOCKED
     */
    public synchronized void blockedMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
