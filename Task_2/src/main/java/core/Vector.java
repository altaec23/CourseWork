package core;

/**
 * Класс, описывающий вектор (в трёхмерном пространстве)
 *
 * @author alekseev.a
 * @since 1.0
 */
public record Vector(double x, double y, double z) {

    /**
     * Метод, вычисляющий длину вектора
     *
     * @return длина вектора
     */
    double lengthVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Метод, вычисляющий скалярное произведение с другим вектором
     *
     * @param vector другой вектор
     * @return скалярное произведение
     */
    public double scalarProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    /**
     * Метод, вычисляющий векторное произведение с другим вектором
     *
     * @param vector другой вектор
     * @return векторное произведение
     */
    public Vector vectorsProduct(Vector vector) {
        return new Vector(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    /**
     * Метод, вычисляющий угол между векторами (или косинус угла)
     *
     * @param vector другой вектор
     * @return косинус угла
     */
    public double angleVectors(Vector vector) {
        double scalarProduct = this.scalarProduct(vector);
        double moduleA = Math.abs(this.lengthVector());
        double moduleB = Math.abs(vector.lengthVector());
        return Math.cos(scalarProduct / moduleA * moduleB);
    }

    /**
     * Методы суммы векторов
     *
     * @param vector другой вектор
     * @return новый вектор в результате суммы
     */
    public Vector sumVectors(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    /**
     * Методы разности векторов
     *
     * @param vector другой вектор
     * @return новый вектор в результате разности
     */
    public Vector subVectors(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    /**
     * Метод, который принимает целое число N, и возвращает массив
     * случайных векторов размером N.
     *
     * @param n кол-во элементов в массиве
     * @return массив векторов
     */
    static Vector[] arrayRandomVectors(int n) {

        var vectors = new Vector[n];
        for (var i = 0; i < n; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
