package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 8.02.2019
 */
public class DynamicArrayTest {
    private DynamicArray<Integer> arr = new DynamicArray<>();

    @Before
    public void setUp() {
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        arr.add(11);
    }

    @Test
    public void whenMore10ElementsThenExtraCapacity() {
        assertThat(arr.getContainer().length, is(20));
        assertThat(arr.get(10), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        Iterator<Integer> it = arr.iterator();
        arr.add(12);
        arr.add(13);
        arr.add(14);
        arr.add(15);
        arr.add(16);
        arr.add(17);
        arr.add(18);
        arr.add(19);
        arr.add(20);
        arr.add(21);
        it.next();
    }

    @Test
    public void whenHasNextThenResult() {
        DynamicArray<Integer> tmp = new DynamicArray<>();
        tmp.add(1);
        Iterator<Integer> it = tmp.iterator();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenEmptyHasNextThenResultFalse() {
        DynamicArray<Integer> tmp = new DynamicArray<>();
        Iterator<Integer> it = tmp.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenHasNextSize10ThenResultFalse() {
        DynamicArray<Integer> tmp = new DynamicArray<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);
        tmp.add(6);
        tmp.add(7);
        tmp.add(8);
        tmp.add(9);
        tmp.add(10);
        Iterator<Integer> it = tmp.iterator();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}