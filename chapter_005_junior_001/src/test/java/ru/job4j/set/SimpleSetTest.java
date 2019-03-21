package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 21.03.2019
 */
public class SimpleSetTest {
    private SimpleSet<String> simpleSet = new SimpleSet<>();
    private Iterator<String> it = simpleSet.iterator();

    @Test
    public void whenAddThenResult() {
        simpleSet.add("1");
        simpleSet.add("2");
        simpleSet.add("3");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("3"));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddDoubleThenResult() {
        simpleSet.add("0");
        simpleSet.add("0");
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("0"));
        assertThat(it.hasNext(), is(false));
    }
}