package core.nfc;

import core.apdu.ApduReader;

/**
 * Класс ридера Uno с возможностью общения с картой через apdu команды
 *
 * @author alekseev.a
 * @since 1.0
 */
public class UnoApduReader implements ApduReader {
    public UnoApduReader() {
        System.out.println("Uno apdu reader created ...");
    }

    /**
     * Метод отправки apdu команды
     *
     * @param command команда в виде набора байт
     * @return результат выполнения apdu команды
     */
    @Override
    public byte[] sendApduCommand(byte[] command) {
        return new byte[0];
    }
}
