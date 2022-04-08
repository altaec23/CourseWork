package core;

import core.bank.Bank;
import core.bank.Keeper;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Поток обсервер, следит за состоянием общего кол-ва средств в банке
 *
 * @author alekseev.a
 * @since 1.0
 */
public class ObserverThread extends Thread {

    private final Bank bank;
    private final int sumBank;

    public ObserverThread(Bank bank) {
        this.bank = bank;
        this.sumBank = bank.getSumBank();
    }

    /**
     * Метод запуска обсервера, получает общую сумму банка из пропертей PropertiesStorage, далее получает список всех киперов,
     * сравнивает сумму эталона, с суммой которая есть сейчас, если ошибка, то выкидываем RuntimeException
     */
    @Override
    public void run() {

        var sum = new BigDecimal(sumBank);

        while (true) {
            bank.getListKeepers().forEach(Keeper::lock);

            if (sum.compareTo(sumInSystemNow()) != 0) {
                throw new RuntimeException("Error, sum properties != now sum");
            }
            bank.getListKeepers().forEach(Keeper::unlock);

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод получения текущей всей суммы сердств в банке
     *
     * @return текущая сумма в банке
     */
    private BigDecimal sumInSystemNow() {
        return bank.getListKeepers()
                .stream().map(a -> new Keeper(a.getBalance().intValue())).collect(Collectors.toList())
                .stream().map(Keeper::getBalance).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
