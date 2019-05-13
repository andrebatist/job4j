package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Элемент дерева
 *
 * @param <E> Тип элемента
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.05.2019
 */
public class Node<E> {
    private final E value;

    private final List<Node<E>> children = new ArrayList<>();

    public Node(E value) {
        this.value = Objects.requireNonNull(value);
    }

    public void add(Node<E> child) {
        children.add(child);
    }

    public E getValue() {
        return value;
    }

    public List<Node<E>> getChildren() {
        return children;
    }

    public boolean eqValue(E that) {
        return this.value.equals(that);
    }
}
