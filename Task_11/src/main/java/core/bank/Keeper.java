package core.bank;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Класс хранящий объекты кошелька
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Keeper {

    private BigDecimal balance;
    /**
     * Объект-замок для регулирования доступа к счету
     */
    private final Lock lock;

    public Keeper(int sum) {
        balance = BigDecimal.valueOf(sum);
        lock = new ReentrantLock();
    }

    /**
     * Добавление сумммы
     *
     * @param amount сумма к добавлению
     */
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    /**
     * Вычитание сумммы
     *
     * @param amount сумма к вычитанию
     */
    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    /**
     * Блокировка объекта
     */
    public void lock() {
        lock.lock();
    }

    /**
     * Разблокировка объекта
     */
    public void unlock() {
        lock.unlock();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Keeper{" +
                "balance=" + balance +
                '}';
    }
}
