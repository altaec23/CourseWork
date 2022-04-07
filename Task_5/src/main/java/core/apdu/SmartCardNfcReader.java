package core.apdu;

import core.nfc.NfcReader;

/**
 * Класс создания ридера smartcard с возможность считывания данных посредством nfc чипа
 *
 * @author alekseev.a
 * @since 1.0
 */
public class SmartCardNfcReader implements NfcReader {
    public SmartCardNfcReader() {
        System.out.println("Smart card nfc reader created...");
    }

    /**
     * Метод старта транзакции
     *
     * @param codeOperation код операции
     * @param sum           сумма операции
     * @return результат операции
     */
    @Override
    public byte[] startTransaction(int codeOperation, long sum) {
        return new byte[0];
    }
}
