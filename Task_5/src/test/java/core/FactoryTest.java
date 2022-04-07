package core;

import core.apdu.SmartCardApduReader;
import core.apdu.SmartCardFactory;
import core.apdu.SmartCardNfcReader;
import core.nfc.UnoApduReader;
import core.nfc.UnoNfcReader;
import core.nfc.UnoReaderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author alekseev.a
 * @since 1.0
 */
class FactoryTest {
    @Test
    void smartCardsTest() {
        CardReadersFactory smartApduFactory = new SmartCardFactory();
        assertEquals(SmartCardApduReader.class, smartApduFactory.createApduReader().getClass());

        CardReadersFactory smartNfcFactory = new SmartCardFactory();
        assertEquals(SmartCardNfcReader.class, smartNfcFactory.createNfcReader().getClass());
    }

    @Test
    void unoTest() {
        CardReadersFactory unoApduFactory = new UnoReaderFactory();
        assertEquals(UnoApduReader.class, unoApduFactory.createApduReader().getClass());

        CardReadersFactory unoNfcFactory = new UnoReaderFactory();
        assertEquals(UnoNfcReader.class, unoNfcFactory.createNfcReader().getClass());
    }


}
