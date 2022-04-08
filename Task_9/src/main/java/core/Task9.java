package core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для проведения тестов с методами:
 * doBeforeAll - который выполняется до всех методов-тестов
 * doTestMethods - методы-тесты, которые имеют приоритет
 * doAfterAll - метод-тест, который выполняется после всех методов-тестов
 *
 * @author alekseev.a
 * @since 1.0
 */
public class Task9 {

    /**
     * Метод запуска и анализа методов в классе nameRunClass
     *
     * @param nameRunClass анализируемый и запускаемый класс
     * @return список выполненных методов внутри класса nameRunClass
     */
    public static List<Object> start(String nameRunClass) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> runClass = Class.forName(nameRunClass);
        Method[] declaredMethods = runClass.getDeclaredMethods();

        List<Method> doBeforeAll = getDoBeforeAll(declaredMethods);
        List<Method> doTestMethods = getDoTestMethods(declaredMethods);
        List<Method> doAfterAll = getDoAfterAll(declaredMethods);

        ArrayList<Object> resultList = new ArrayList<>();
        invokeMethod(doBeforeAll, runClass, resultList);
        invokeMethod(doTestMethods.stream()
                .sorted((method1, method2) -> method2.getAnnotation(DoTest.class).order() - method1.getAnnotation(DoTest.class).order())
                .collect(Collectors.toList()), runClass, resultList);
        invokeMethod(doAfterAll, runClass, resultList);

        return resultList;
    }

    /**
     * Метод создания и проверки листа с аннотацией DoBeforeAll
     *
     * @param declaredMethods все имеющиеся методы класса
     * @return лист с DoBeforeAll
     */
    private static List<Method> getDoBeforeAll(Method[] declaredMethods) {
        List<Method> list = new ArrayList<>();
        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(DoBeforeAll.class)) {
                list.add(m);
            }
        }
        if (list.size() > 1) {
            throw new RuntimeException("No correct count size DoBefore methode");
        }
        return list;
    }

    /**
     * Метод создания и проверки листа с аннотацией DoTest
     *
     * @param declaredMethods все имеющиеся методы класса
     * @return лист с DoTest
     */
    private static List<Method> getDoTestMethods(Method[] declaredMethods) {
        List<Method> list = new ArrayList<>();
        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(DoTest.class)) {
                list.add(m);
            }
        }
        if (list.isEmpty()) {
            throw new RuntimeException("No correct count size DoTest methode");
        }
        return list;
    }

    /**
     * Метод создания и проверки листа с аннотацией getDoAfterAll
     *
     * @param declaredMethods все имеющиеся методы класса
     * @return лист с getDoAfterAll
     */
    private static List<Method> getDoAfterAll(Method[] declaredMethods) {
        List<Method> list = new ArrayList<>();
        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(DoAfterAll.class)) {
                list.add(m);
            }
        }
        if (list.size() > 1) {
            throw new RuntimeException("No correct count size DoAfterAll methode");
        }
        return list;
    }

    /**
     * Метод вызова методов класса nameRunClass, а также их добавления в лист resultList
     *
     * @param methods      методы класса
     * @param nameRunClass имя класса в котором находятся методы
     * @param resultList   список вызванных методов
     */
    public static void invokeMethod(Collection<Method> methods, Class<?> nameRunClass, List<Object> resultList) throws
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (Method method : methods) {
            method.setAccessible(true);
            resultList.add(method.invoke(nameRunClass.getDeclaredConstructor().newInstance()));
        }
    }
}
