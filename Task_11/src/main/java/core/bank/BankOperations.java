package core.bank;

import java.math.BigDecimal;

/**
 * Класс хранящий в себе доступные операции с кошельками клиентов
 *
 * @author alekseev.a
 * @since 1.0
 */
public class BankOperations {

    /**
     * Операция перевода средств с одного кошелька на другой
     *
     * @param source    кошелек источник
     * @param recipient кошелек получатель
     * @param amount    сумма перевода указана с
     */
    public void transferP2P(Keeper source, Keeper recipient, BigDecimal amount) {
        if (checkBalance(source, amount)) {
            source.debit(amount);
            recipient.deposit(amount);
        }
    }

    /**
     * Операция проверки баланса на запрашиваемую сумму
     *
     * @param keeper кошелек с суммой
     * @param amount сумма которую хотим списать
     * @return можем списать или нет
     */
    private boolean checkBalance(Keeper keeper, BigDecimal amount) {
        return keeper.getBalance().compareTo(amount) < 0;
    }

}
