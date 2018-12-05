package ru.job4j.tracker;

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
 * @since 15.11.2018
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Тест на ввод пользователем неверного символа.
     */
//    @Test
//    public void whenInvalidInput() {
//        ValidateInput input = new ValidateInput(
//                new StubInput(new String[]{"invalid", "1"})
//        );
//        input.ask("Enter", new int[]{1});
//        assertThat(
//                this.mem.toString(),
//                is(
//                        String.format("Please enter valid data again.%n")
//                )
//        );
//    }
//
//    /**
//     * Тест на ввод пользователем неверного числа.
//     */
//    @Test
//    public void whenInvalidInputNum() {
//        ValidateInput input = new ValidateInput(
//                new StubInput(new String[]{"66", "1"})
//        );
//        input.ask("Enter", new int[]{1});
//        assertThat(
//                this.mem.toString(),
//                is(
//                        String.format("Please select number from menu.%n")
//                )
//        );
//    }
}