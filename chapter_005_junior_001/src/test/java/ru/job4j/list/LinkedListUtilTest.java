package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 18.03.2019
 */
public class LinkedListUtilTest {

    private LinkedListUtil util = new LinkedListUtil();

    @Test
    public void whenListLockedThenTrue() {
        Node<String> n3 = new Node<>("3");
        Node<String> n2 = new Node<>("2");
        Node<String> n1 = new Node<>("1");
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;
        assertThat(util.isCycled(n1), is(true));
    }

    @Test
    public void whenListLockedAtMiddleThenTrue() {
        Node<String> n3 = new Node<>("3");
        Node<String> n2 = new Node<>("2");
        Node<String> n1 = new Node<>("1");
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;
        assertThat(util.isCycled(n1), is(true));
    }

    @Test
    public void whenUnlockedListThenFalse() {
        Node<String> n3 = new Node<>("3");
        Node<String> n2 = new Node<>("2");
        Node<String> n1 = new Node<>("1");
        n1.next = n2;
        n2.next = n3;
        assertThat(util.isCycled(n1), is(false));
    }
}