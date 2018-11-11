package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
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
     * Дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Символ разделителя.
     */
    private final String ln = System.lineSeparator();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    /**
     * Тест на вывод квадрата.
     */
    @Test
    public void whenDrawSquare() {
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
    }

    /**
     * Тест на вывод треугольника.
     */
    @Test
    public void whenDrawTriangle() {
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
    }
}