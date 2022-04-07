package core;

import java.util.*;

/**
 * Утильный класс для получения List с повторящимися элементами из 2 коллекций.
 *
 * @author alekseev.a
 * @since 1.0
 */
public class UserBankUtil {

    UserBankUtil() {
    }

    /**
     * Возвращает список с одинаковыми элементами из 2 коллекций
     *
     * @param collA коллекция из элементов класса UserBank
     * @param collB коллекция из элементов класса UserBank
     * @return список с одинаковыми элементами из 2 коллекций
     */
    public static List<UserBank> findDuplicates1(Collection<UserBank> collA, Collection<UserBank> collB) {
        Set<UserBank> setA = new HashSet<>(collA);
        Set<UserBank> setB = new HashSet<>(collB);

        Collection<UserBank> dublicates = new HashSet<>();
        for (UserBank userBank : setA) {
            if (setB.contains(userBank)) {
                dublicates.add(userBank);
            }
        }
        return new ArrayList<>(dublicates);
    }

    /**
     * Возвращает список с одинаковыми элементами из 2 коллекций
     *
     * @param collA коллекция из элементов класса UserBank
     * @param collB коллекция из элементов класса UserBank
     * @return список с одинаковыми элементами из 2 коллекций
     */
    public static List<UserBank> findDuplicates2(Collection<UserBank> collA, Collection<UserBank> collB) {
        HashSet<UserBank> dublicates = new HashSet<>(collA);
        HashSet<UserBank> setB = new HashSet<>(collB);
        dublicates.retainAll(setB);
        return new ArrayList<>(dublicates);
    }

    /**
     * Получить список элементов класса UserBank входящих в обе коллекции
     *
     * @param collA коллекция элементов класса UserBank
     * @param collB коллекция элементов класса UserBank
     * @return список элементов класса UserBank входящих в обе коллекции
     */
    public static List<UserBank> findDuplicates3(Collection<UserBank> collA, Collection<UserBank> collB) {
        List<UserBank> dublicates = new ArrayList<>();
        for (UserBank userBank : collA) {
            if (collB.contains(userBank) && !dublicates.contains(userBank)) {
                dublicates.add(userBank);
            }
        }
        return dublicates;
    }
}
