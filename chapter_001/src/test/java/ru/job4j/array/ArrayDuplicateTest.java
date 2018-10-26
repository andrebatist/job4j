package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 26.10.2018
 */
public class ArrayDuplicateTest {
    /**
     * Test массив с несколькими дубликатами.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] rst = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Супер", "Привет", "Супер", "Супер", "Мир"});
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        assertThat(rst, is(expect));
    }

    /**
     * Test массив с дубликатами.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateSmaller() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] rst = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        assertThat(rst, is(expect));
    }

}