package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;

    private static class Node<T> {
        T date;
        Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }

    public void add(T date) {
        Node<T> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public T get(int index) {
        SingleLinkedList.Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                SingleLinkedList.Node<T> result = first;
                if (pos == 0) {
                    pos++;
                    return first.date;
                }
                for (int i = 0; i < pos; i++) {
                    result = result.next;
                    pos++;
                }
                return result.date;
            }
        };
    }
}
