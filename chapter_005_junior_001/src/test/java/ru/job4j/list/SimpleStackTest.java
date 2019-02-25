package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 20.02.2019
 */
public class SimpleStackTest {

    @Test
    public void whenPush3thenPoll3() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        stack.setStack(list);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.getSize(), is(3));
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
        assertThat(stack.getSize(), is(0));
    }
}