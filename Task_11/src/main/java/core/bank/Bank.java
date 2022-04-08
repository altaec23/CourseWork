package core.bank;

import core.PropertiesStorage;

import java.util.List;
import java.util.Random;

/**
 * Класс хранящий в себе операции доступные на хосте (банке), а также информацию о кошельках
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Bank {
    private final List<Keeper> listKeepers;
    private final int maxSumTransfer;
    private final int sumBank;

    /**
     * Конструктор объекта банк, включает в себя список кошельков, а также название стореджа где хранится настроечная информация по счетам
     *
     * @param listKeepers     лист из кошельков
     * @param bankStorageName имя проперти стореджа
     */
    public Bank(List<Keeper> listKeepers, String bankStorageName) {
        this.listKeepers = listKeepers;

        maxSumTransfer = new PropertiesStorage(bankStorageName).getMaxTransferSum();
        sumBank = new PropertiesStorage(bankStorageName).getSumBank();
    }

    public List<Keeper> getListKeepers() {
        return listKeepers;
    }

    /**
     * Возвращает случайный кошелек
     *
     * @return случайный кошелек из списка
     */
    public Keeper getRandomKeeper() {
        return listKeepers.get(new Random().nextInt(listKeepers.size()));
    }

    /**
     * Возвращает максимальную доступную сумму перевода
     *
     * @return максимальная допустимая сумма перевода
     */
    public int getMaxSumTransfer() {
        return maxSumTransfer;
    }

    /**
     * Метод возвращает общую сумму кэша в банке
     *
     * @return сумма кэша в банке
     */
    public int getSumBank() {
        return sumBank;
    }
}
