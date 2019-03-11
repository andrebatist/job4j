package ru.job4j.list;

import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 11.03.2019
 */
public class DoubleLinkedList<E> {
    private Node first;
    private Node last;
    private int size;


    public void add(E value) {
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        size++;
    }

    public E removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = last;
        if (last.prev == null) {
            first = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
        return node.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    private class Node {
        private final E value;
        private Node prev;
        private Node next;

        public Node(E value) {
            this.value = value;
        }
    }
}
