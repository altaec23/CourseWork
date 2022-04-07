package core.nfc;

/**
 * Интерфейс картридера для взаимодействия с картой посредством nfc
 *
 * @author alekseev.a
 * @since 1.0
 */
public interface NfcReader {
    /**
     * Метод запускающий старт транзакции на nfc устройстве
     *
     * @param codeOperation код операции
     * @param sum           сумма операции
     * @return результат выполнения команды
     */
    byte[] startTransaction(int codeOperation, long sum);
}
