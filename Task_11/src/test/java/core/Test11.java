package core;


import core.bank.Bank;
import core.bank.BankOperations;
import core.bank.Keeper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Тест класс на проверку обсервера
 * Создается сторедж, затем берутся значения с пропертей, далее распределеяем средства по кошелькам путем sumBank/countKeepers
 *
 * @author alekseev.a
 * @since 1.0
 */
class TestMoveMoney {

    /**
     * Тест по 1 успешному сценарию
     */

    @Test
    void successObserverTest1() {
        Properties properties = new PropertiesStorage("setting.properties").getProperties();
        int numberOfClients = Integer.parseInt(properties.getProperty("countClients"));
        int countKeepers = Integer.parseInt(properties.getProperty("countKeepers"));
        int amount = Integer.parseInt(properties.getProperty("sumBank"));

        int averageSum = amount / countKeepers;
        List<Keeper> list = IntStream.range(0, countKeepers)
                .mapToObj(i -> {
                    if (i == countKeepers - 1) {
                        return new Keeper(amount - averageSum * (countKeepers - 1));
                    }
                    return new Keeper(averageSum);
                }).collect(Collectors.toList());

        Bank bank = new Bank(list, "setting.properties");
        BankOperations bankOperations = new BankOperations();
        ObserverThread daemonThread = new ObserverThread(bank);
        daemonThread.setDaemon(true);
        daemonThread.start();

        IntStream.range(0, numberOfClients)
                .forEach(i ->
                        new Thread(new Client(bankOperations, bank)).start());
    }

    /**
     * Второй сценарий -  Негативный сценарий. Ожидаем эксепшен от обсервера за счет добавление лишней суммы
     */
    @Test
    void failedObserverTest2() {
        Properties properties = new PropertiesStorage("setting2.properties").getProperties();

        int numberOfClients = Integer.parseInt(properties.getProperty("countClients"));
        System.out.println("numberOfClients" + numberOfClients);
        List<Keeper> list;

        int countKeepers = Integer.parseInt(properties.getProperty("countKeepers"));
        int amount = Integer.parseInt(properties.getProperty("sumBank"));

        int averageSum = amount / countKeepers;

        list = IntStream.range(0, countKeepers)
                .mapToObj(i -> {
                    if (i == countKeepers - 1) {
                        return new Keeper(amount - averageSum * (countKeepers - 1));
                    }
                    return new Keeper(averageSum);
                }).collect(Collectors.toList());

        if (properties.getProperty("fail") != null && properties.getProperty("fail").equals("1")) {
            list.get(0).deposit(BigDecimal.valueOf(600));
        }

        Bank bank = new Bank(list, "setting2.properties");
        BankOperations bankOperations = new BankOperations();
        ObserverThread daemonThread = new ObserverThread(bank);
        daemonThread.setDaemon(true);
        daemonThread.start();

        IntStream.range(0, numberOfClients)
                .forEach(i ->
                        new Thread(new Client(bankOperations, bank)).start());
    }

    /**
     * Третий сценарий -  Поизитивный сценарий. Всего 2 счета
     */
    @Test
    void okTwoKeeperObserverTest3() {
        Properties properties = new PropertiesStorage("setting3.properties").getProperties();

        int numberOfClients = Integer.parseInt(properties.getProperty("countClients"));
        int countKeepers = Integer.parseInt(properties.getProperty("countKeepers"));
        int amount = Integer.parseInt(properties.getProperty("sumBank"));

        int averageSum = amount / countKeepers;

        List<Keeper> list = IntStream.range(0, countKeepers)
                .mapToObj(i -> {
                    if (i == countKeepers - 1) {
                        return new Keeper(amount - averageSum * (countKeepers - 1));
                    }

                    return new Keeper(averageSum);
                }).collect(Collectors.toList());

        System.out.println(list.toString());
        Bank bank = new Bank(list, "setting3.properties");
        BankOperations bankOperations = new BankOperations();
        ObserverThread daemonThread = new ObserverThread(bank);
        daemonThread.setDaemon(true);
        daemonThread.start();

        IntStream.range(0, numberOfClients)
                .forEach(i ->
                        new Thread(new Client(bankOperations, bank)).start());
    }


}
