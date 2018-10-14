package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 14.10.2018
 */
public class PointTest {

    /**
     * Test distanceTo.
     */
    @Test
    public void distanceBetweenTwoPointsX1ZeroY1OneAndX2TwoY2Five() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        double distance = a.distanceTo(b);
        assertThat(distance, closeTo(4.4, 0.1));
    }
}