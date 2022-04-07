package core.apdu;

/**
 * Интерфейс картридера для взаимодействия с картой посредством apdu команд
 *
 * @author alekseev.a
 * @since 1.0
 */

public interface ApduReader {
    /**
     * Метод отправки apdu команд устройству
     *
     * @param command команда в виде набора байт
     * @return результат выполнения команды
     */
    byte[] sendApduCommand(byte[] command);
}
