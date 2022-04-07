package core;

/**
 * @author alekseev.a
 * @see Vector для выбора нужно метода
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {

        var x = Double.parseDouble(args[0]);
        var y = Double.parseDouble(args[1]);
        var z = Double.parseDouble(args[2]);

        var vector = new Vector(x, y, z);

    }
}
