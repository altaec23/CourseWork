package core.apdu;

import core.CardReadersFactory;
import core.nfc.NfcReader;

/**
 * Фабрика ридера smartcard с возможностью общечения как через apdu команды, так и посредством считывания через nfc чип
 *
 * @author alekseev.a
 * @since 1.0
 */
public class SmartCardFactory implements CardReadersFactory {
    /**
     * Метод создания nfc ридера от компании smartcard
     *
     * @return объект класса nfc ридера
     */
    @Override
    public NfcReader createNfcReader() {
        return new SmartCardNfcReader();
    }

    /**
     * Метод создания apdu ридера от компании smartcard
     *
     * @return объект класса apdu ридера
     */
    @Override
    public ApduReader createApduReader() {
        return new SmartCardApduReader();
    }
}
