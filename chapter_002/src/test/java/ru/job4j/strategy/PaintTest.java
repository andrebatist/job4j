package ru.job4j.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 10.11.2018
 */
public class PaintTest {
    /**
     * Тест на вывод квадрата.
     */
    @Test
    public void whenDrawSquare() {
        String ln = System.lineSeparator();
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .append(ln)
                                .append("++++")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdOut);
    }

    /**
     * Тест на вывод треугольника.
     */
    @Test
    public void whenDrawTriangle() {
        String ln = System.lineSeparator();
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append(ln)
                                .append("  +++  ")
                                .append(ln)
                                .append(" +++++ ")
                                .append(ln)
                                .append("+++++++")
                                .append(ln)
                                .toString()
                )
        );
        System.setOut(stdOut);
    }
}