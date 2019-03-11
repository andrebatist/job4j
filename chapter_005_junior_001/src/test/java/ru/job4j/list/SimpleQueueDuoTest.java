package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 11.03.2019
 */
public class SimpleQueueDuoTest {
    private final SimpleQueueDuo<String> queue = new SimpleQueueDuo<>();

    @Test
    public void whenPushElementsThenPoll() {
        queue.push("1");
        queue.push("2");
        assertThat(queue.poll(), is("1"));
        queue.push("3");
        assertThat(queue.poll(), is("2"));
        assertThat(queue.poll(), is("3"));
        queue.push("4");
        queue.push("5");
        assertThat(queue.poll(), is("4"));
        assertThat(queue.poll(), is("5"));
    }

    @Test
    public void whenEmptyThenPollReturnsNull() {
        assertNull(queue.poll());
    }
}