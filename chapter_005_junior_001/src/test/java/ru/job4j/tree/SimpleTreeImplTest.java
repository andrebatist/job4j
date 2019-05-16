package ru.job4j.tree;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 13.05.2019
 */
public class SimpleTreeImplTest {
    private final SimpleTreeImpl<Integer> tree = new SimpleTreeImpl<>(1);

    @Test
    public void when6ElFindLastThen6() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        var found = tree.findBy(6);
        assertThat(found.isPresent(), is(true));
        assertThat(found.get().getValue(), is(6));
    }

    @Test
    public void whenFindNonExistingThenNotPresent() {
        tree.add(1, 2);
        assertThat(tree.findBy(6).isPresent(), is(false));
    }

    @Test
    public void whenIteratorThenIteratesAll() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);
        tree.add(3, 7);
        tree.add(3, 8);
        tree.add(7, 9);
        int expected = 1;
        for (Integer value : tree) {
            assertThat(value, is(expected++));
        }
    }

    @Test
    public void whenAddDuplicateThenNoDubs() {
        assertThat(tree.add(1, 2), is(true));
        assertThat(tree.add(1, 2), is(false));
        Node<Integer> parent = tree.findBy(1).orElseThrow();
        assertThat(parent.getChildren().size(), is(1));
        assertThat(tree.getSize(), is(2));
    }

    @Test
    public void whenAddToNonExistingThenNotAdd() {
        assertThat(tree.add(22, 3), is(false));
        Node<Integer> parent = tree.findBy(1).orElseThrow();
        assertThat(parent.getChildren().size(), is(0));
        assertThat(tree.getSize(), is(1));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterateThenModificationThenException() {
        Iterator<Integer> it = tree.iterator();
        tree.add(1, 2);
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIterateNoElementsThenException() {
        Iterator<Integer> it = tree.iterator();
        it.next();
        it.next();
    }

    @Test
    public void whenIsBinaryThenTrue() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        assertThat(tree.isBinary(), is(true));
    }

    @Test
    public void whenNonBinaryTreeThenFalse() {
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        assertThat(tree.isBinary(), is(false));
    }
}