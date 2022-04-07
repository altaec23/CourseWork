package core.apdu;

import java.util.Arrays;

/**
 * Класс ридера smartcard с возможностью общения с картой через apdu команды
 *
 * @author alekseev.a
 * @since 1.0
 */
public class SmartCardApduReader implements ApduReader {
    public SmartCardApduReader() {
        System.out.println("Create smartcard apdu driver...");
    }

    /**
     * Метод отправки apdu команды
     *
     * @param command команда в виде набора байт
     * @return результат команды
     */
    @Override
    public byte[] sendApduCommand(byte[] command) {
        System.out.println("Send apdu command uno " + Arrays.toString(command));
        return new byte[0];
    }
}
