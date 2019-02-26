package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {

    @Test
    public void whenPollThenRemoved() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        SimpleStack<Integer> stack = new SimpleStack<>();
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        stack.setStack(list);
        queue.setQueue(stack);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
    }
}