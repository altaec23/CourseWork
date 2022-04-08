package core;

import java.io.*;
import java.util.Properties;

/**
 * Класс для получения файла с пропертями
 *
 * @author alekseev.a
 * @since 1.0
 */
public class PropertiesStorage {

    private final String nameConfig;

    public PropertiesStorage(String nameConfig) {
        this.nameConfig = nameConfig;
    }

    public Properties getProperties() {
        var properties = new Properties();
        try (InputStream io = PropertiesStorage.class.getResourceAsStream(nameConfig)) {
            properties.load(io);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("file do not exist");
        }
    }

    /**
     * Получение максимальной суммы перевода из проперти с ключом maxSumTransfer
     *
     * @return максимально-допустимая сумма пеервода
     */
    public int getMaxTransferSum() {
        return Integer.parseInt(getProperties().getProperty("maxSumTransfer"));
    }

    /**
     * Получить общую сумму банка из проперти
     *
     * @return общая сумма банка до начала переводов
     */
    public int getSumBank() {
        return Integer.parseInt(getProperties().getProperty("sumBank"));
    }
}


