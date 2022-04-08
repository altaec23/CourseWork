package core;

import core.bank.Bank;
import core.bank.BankOperations;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Класс для хранения объектов клиента, а также допустимых операций банка, а также данные самого банка
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Client implements Runnable {

    private final BankOperations bankOperations;
    private final Bank bank;

    /**
     * Максимально допустимая сумма перевода
     */
    private final int maxSum;


    public Client(BankOperations bankOperations, Bank bank) {
        this.bankOperations = bankOperations;
        this.bank = bank;
        this.maxSum = bank.getMaxSumTransfer();
    }

    /**
     * Метод запуска потока клиента на перевод средств с одного случайного счета на другой.
     * Киперы получаются из банка, осуществляется блокировка, проверяется допустимая сумма перевода, осуществляется перевод, осуществляется разблокировка
     */
    @Override
    public void run() {
        var sourceKeeper = bank.getRandomKeeper();
        var recipientKeeper = bank.getRandomKeeper();

        sourceKeeper.lock();
        recipientKeeper.lock();

        var sum = new BigDecimal(new Random().nextInt(maxSum));
        bankOperations.transferP2P(sourceKeeper, recipientKeeper, sum);

        sourceKeeper.unlock();
        recipientKeeper.unlock();
    }
}
