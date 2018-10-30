package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class ArraysSortTest {
    /**
     * Test массив с минимальным элементом первый.
     */
    @Test
    public void whenSortArrayWithTwoElementsMinLeft() {
        ArraysSort arraysSort = new ArraysSort();
        int[] rst = arraysSort.sortArrays(new int[]{1, 3}, new int[]{2, 4});
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(rst, is(expect));
    }

    /**
     * Test массив с минимальным элементом второй.
     */
    @Test
    public void whenSortArrayWithTwoElementsMinRight() {
        ArraysSort arraysSort = new ArraysSort();
        int[] rst = arraysSort.sortArrays(new int[]{2, 4}, new int[]{1, 3});
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(rst, is(expect));
    }
}