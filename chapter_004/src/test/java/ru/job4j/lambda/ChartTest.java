package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 4.01.2019
 */
public class ChartTest {
    /**
     * Тест линейная функция.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Chart chart = new Chart();
        List<Double> result = chart.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тест квадратичная функция.
     */
    @Test
    public void whenQuadraticFunctionThenLinearResults() {
        Chart chart = new Chart();
        List<Double> result = chart.diapason(5, 8, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    /**
     * Тест логарифмическая функция.
     */
    @Test
    public void whenLogFunctionThenLinearResults() {
        Chart chart = new Chart();
        List<Double> result = chart.diapason(5, 6, x -> Math.log(x) + 1);
        assertThat(result.get(0), closeTo(2.6, 2.7));
    }
}