package ru.job4j.condition;

/**
 * Программа расчета расстояния между двумя точками.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между двумя точками.
     *
     * @param that Вторая точка.
     * @return расстояние между двумя точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(Math.pow(that.x - this.x, 2) + Math.pow(that.y - this.y, 2));
    }

    /**
     * Main.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        a.distanceTo(b);
    }
}
