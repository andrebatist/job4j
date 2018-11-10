package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 10.11.2018
 */
public class SquareTest {
    /**
     * Тест на отрисовку квадрата.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ln = System.lineSeparator();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .toString()
                )
        );
    }
}