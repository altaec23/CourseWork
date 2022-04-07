package core.nfc;

import core.CardReadersFactory;
import core.apdu.ApduReader;

/**
 * Фабрика для создания ридеров компании Uno, 2 видов взаимодействия с картой. Nfc ридеры, и ридеры принимающие apdu команды
 *
 * @author alekseev.a
 * @since 1.0
 */

public class UnoReaderFactory implements CardReadersFactory {
    @Override
    public NfcReader createNfcReader() {
        return new UnoNfcReader();
    }

    @Override
    public ApduReader createApduReader() {
        return new UnoApduReader();
    }
}
