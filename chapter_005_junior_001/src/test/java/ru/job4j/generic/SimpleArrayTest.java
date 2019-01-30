package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 30.01.2019
 */
public class SimpleArrayTest {
    @Test
    public void whenAddThenResult() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        simpleArray.add(20);
        int expect = 20;
        assertThat(simpleArray.get(0), is(expect));
    }

    @Test
    public void whenRemoveThenResult() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("str1");
        simpleArray.add("str2");
        simpleArray.add("str3");
        String expect = "str3";
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(expect));
    }

    @Test
    public void whenSetThenResult() {
        SimpleArray<String> simpleArray = new SimpleArray<>(1);
        simpleArray.add("str1");
        simpleArray.set(0, "str2");
        String expect = "str2";
        assertThat(simpleArray.get(0), is(expect));
    }


    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorEmptyTest() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}