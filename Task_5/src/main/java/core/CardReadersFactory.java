package core;

import core.apdu.ApduReader;
import core.nfc.NfcReader;

/**
 * Интерфейс, являющийся абстрактной фабрикой для создания nfc ридеров, и apdu ридеров
 *
 * @author alekseev.a
 * @since 1.0
 */
public interface CardReadersFactory {

    NfcReader createNfcReader();

    ApduReader createApduReader();
}
