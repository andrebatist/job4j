package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 18.10.2018
 */
public class TriangleTest {

    /**
     * Test на вычисление площади треугольника.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }

    /**
     * Test на вычисление площади треугольника с неправильными сторонами.
     */
    @Test
    public void whenAreaSetThreePointsWrongThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        Point c = new Point(2, 0);

        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = -1;
        assertThat(result, closeTo(expected, 0.1));
    }
}