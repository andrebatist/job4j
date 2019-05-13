package ru.job4j.tree;

import java.util.*;

/**
 * Своя реализация SimpleTree
 *
 * @param <T> Тип элементов дерева
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.05.2019
 */
public class SimpleTreeImpl<T> implements SimpleTree<T> {

    private final Node<T> root;

    private int size;

    private int modCount;

    public SimpleTreeImpl(T rootVal) {
        this.root = new Node<>(rootVal);
        this.size = 1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(T parent, T child) {
        Optional<Node<T>> destination = findBy(parent);
        if (destination.isEmpty()) {
            return false;
        }
        Optional<Node<T>> duplicate = findBy(child);
        if (duplicate.isPresent()) {
            return false;
        }
        destination.get().add(new Node<>(child));
        this.size++;
        this.modCount++;
        return true;
    }

    @Override
    public Optional<Node<T>> findBy(T value) {
        NodeIterator it = new NodeIterator();
        while (it.hasNext()) {
            Node<T> node = it.next();
            if (node.eqValue(value)) {
                return Optional.of(node);
            }
        }
        return Optional.empty();
    }

    private class NodeIterator implements Iterator<Node<T>> {

        private final Queue<Node<T>> nodes = new LinkedList<>();

        private final int expectedModCount = SimpleTreeImpl.this.modCount;

        private NodeIterator() {
            nodes.add(root);
        }

        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }

        @Override
        public Node<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != SimpleTreeImpl.this.modCount) {
                throw new ConcurrentModificationException();
            }
            Node<T> node = nodes.remove();
            nodes.addAll(node.getChildren());
            return node;
        }
    }

    private class ElementIterator implements Iterator<T> {
        private final NodeIterator nodeIterator = new NodeIterator();

        @Override
        public boolean hasNext() {
            return nodeIterator.hasNext();
        }

        @Override
        public T next() {
            return nodeIterator.next().getValue();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementIterator();
    }
}
