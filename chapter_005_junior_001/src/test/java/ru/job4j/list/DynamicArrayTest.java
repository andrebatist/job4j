package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.stream.IntStream;

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
        addElements(arr, 1, 11);
    }

    @Test
    public void whenMore10ElementsThenExtraCapacity() {
        assertThat(arr.getContainer().length, is(20));
        assertThat(arr.get(10), is(11));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void shoulThrowConcurrentModificationException() {
        Iterator<Integer> it = arr.iterator();
        addElements(arr, 12, 21);
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
        addElements(tmp, 1, 10);
        Iterator<Integer> it = tmp.iterator();
        IntStream.range(0, 9).forEach(i -> it.next());
        assertThat(it.hasNext(), is(true));
        it.next();
        assertThat(it.hasNext(), is(false));
    }

    private void addElements(DynamicArray<Integer> tmp, int start, int finish) {
        IntStream.range(start, finish + 1).forEach(tmp::add);
    }
}