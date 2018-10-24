package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 24.10.2018
 */
public class BubbleSortTest {
    /**
     * Test на сортировку масива из 10 элементов.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] rst = bubbleSort.sort(new int[]{1, 9, 0, 4, 2, 3, 7, 6, 8, 5});
        int[] expect = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(rst, is(expect));
    }
}