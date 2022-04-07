package core;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс консольного калькулятора, умеющий производить базовые вычисления
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 2 числа поочереди. Затем введите операцию, которую Вы хотите выполнить между этими числами");
            var oneNumber = getNumber(scanner);
            var twoNumber = getNumber(scanner);
            System.out.print("Введите оператор: ");
            String expression = scanner.next();
            try {
                double result = calculate(expression, oneNumber, twoNumber);
                System.out.println("Результат : " + oneNumber + expression + twoNumber + " = " + result);
            } catch (Exception e) {
                System.out.println("Делить на '0' нельзя, введите корректное выражение");
            }
        }
    }

    /**
     * Метод парсинга введённого оператора и вычисления результата выражения
     *
     * @param expression введённый оператор
     * @param oneNumber  первое число
     * @param twoNumber  второе число
     * @return результат вычислений
     * @throws Exception при получении NaN или же Infinite
     */
    private static double calculate(String expression, double oneNumber, double twoNumber) throws Exception {
        double result = 0;
        switch (expression) {
            case "+" -> result = oneNumber + twoNumber;
            case "-" -> result = oneNumber - twoNumber;
            case "*" -> result = oneNumber * twoNumber;
            case "/" -> {
                result = oneNumber / twoNumber;
                if (Double.isNaN(result) || Double.isInfinite(result)) {
                    throw new Exception();
                }
            }
            case "%" -> result = oneNumber % twoNumber;
            case "^" -> result = Math.pow(oneNumber, twoNumber);
            default -> System.out.println("Вы ввели недопустимый оператор, повторите ввод выражения");

        }
        return result;
    }

    /**
     * Метод для получения числа с проверкой на int, если не int то просим пользователя ввести ещё раз.
     *
     * @param scan simple text scanner which can parse primitive types and strings using regular expressions.
     * @return введённое пользователем число
     */
    private static double getNumber(Scanner scan) {
        do {
            try {
                System.out.print("Введите число: ");
                return scan.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Повторите ещё раз. (" +
                        "Введённый символ не является числом)");
                scan.nextLine();
            }
        }
        while (true);
    }
}
