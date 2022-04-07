package core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс для тестирования методов поиска дубликатов в двух коллекциях.
 * Метод initData инициализирует стартовые данные
 *
 * @author alekseev.a
 * @since 1.0
 */

class Task6Test {
    List<UserBank> list1;
    List<UserBank> list2;
    List<UserBank> list3;
    List<UserBank> list4;

    @BeforeEach
    public void initData() {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();

        var random = new Random();
        for (int i = 0; i < 100_000; i++) {
            int randomInc = random.nextInt(100);
            list1.add(new UserBank((String.valueOf(i + randomInc)), i + "@gmail.com"));
        }

        for (int i = 0; i < 100_000; i++) {
            int randomInc = random.nextInt(100);
            list2.add(new UserBank((String.valueOf(i + randomInc)), i + "@gmail.com"));
        }

        for (int i = 0; i < 100_000; i++) {
            int randomInc = random.nextInt(100);
            list3.add(new UserBank((String.valueOf(i + randomInc)), i + "@gmail.com"));
            list4.add(new UserBank((String.valueOf(i + randomInc)), i + "@gmail.com"));
        }
    }


    @Test
    void findDuplicates1TimeTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            long start = System.currentTimeMillis();
            List<UserBank> duplicates = UserBankUtil.findDuplicates1(list1, list2);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println(duplicates);
        });
    }

    @Test
    void findDuplicates1DataTest() {
        List<UserBank> duplicates = UserBankUtil.findDuplicates1(list3, list4);
        Assertions.assertEquals(100_000, duplicates.size());
    }


    @Test
    void findDuplicates2TimeTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            long start = System.currentTimeMillis();
            List<UserBank> duplicates = UserBankUtil.findDuplicates2(list1, list2);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println(duplicates);
        });
    }

    @Test
    void findDuplicates2DataTest() {
        List<UserBank> duplicates = UserBankUtil.findDuplicates2(list3, list4);
        Assertions.assertEquals(100_000, duplicates.size());
    }


    //@Test чтобы в дальнейшем проходили тесты, при сборке
    void findDuplicates3TimeTest() {
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(200), () -> {
            long start = System.currentTimeMillis();
            List<UserBank> duplicates = UserBankUtil.findDuplicates3(list1, list2);
            System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
            System.out.println(duplicates);
        });
    }

    @Test
    void findDuplicates3DataTest() {
        List<UserBank> duplicates = UserBankUtil.findDuplicates3(list3, list4);
        Assertions.assertEquals(100_000, duplicates.size());
    }

}
