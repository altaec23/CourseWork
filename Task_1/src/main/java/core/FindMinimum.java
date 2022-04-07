package core;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс для поиска минимума из двух чисел, введенных с командной строки
 *
 * @author alekseev.a
 * @since 1.0
 */
public class FindMinimum {

    public static void main(String[] args) {

        var scan = new Scanner(System.in);

        System.out.println("**** Поиск минимума из 2 чисел **** ");
        int oneNumber = getNumber(scan);
        int twoNumber = getNumber(scan);

        System.out.println("Введённые числа : " + oneNumber + ", " + twoNumber);
        System.out.println("Минимальное из двух числел = " + Math.min(oneNumber, twoNumber));
    }

    /**
     * Метод для получения числа с проверкой на int, если не int то просим пользователя ввести ещё раз.
     *
     * @param scan simple text scanner which can parse primitive types and strings using regular expressions.
     * @return введённое пользователем число
     */
    private static int getNumber(Scanner scan) {
        do {
            try {
                System.out.print("Введите число: ");
                return scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Повторите ещё раз. (" +
                        "Введённый символ не является целым числом)");
                scan.nextLine();
            }
        }
        while (true);
    }
}
