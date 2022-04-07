package core.nfc;

/**
 * Класс ридера Uno с возможностью общения с картой по nfc
 *
 * @author alekseev.a
 * @since 1.0
 */
public class UnoNfcReader implements NfcReader {
    public UnoNfcReader() {
        System.out.println("uno nfc reader created...");
    }

    /**
     * Метод старта транзакции посредством считывания nfc чипа
     *
     * @param codeOperation код операции
     * @param sum           сумма операции
     * @return результат выполенния операции
     */
    @Override
    public byte[] startTransaction(int codeOperation, long sum) {
        return new byte[0];
    }
}
