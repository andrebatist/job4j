package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 14.02.2019
 */
public class SingleLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private int modCount = 0;

    public int getSize() {
        return size;
    }

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
        modCount++;
    }

    public T get(int index) {
        SingleLinkedList.Node<T> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public T delete() {
        SingleLinkedList.Node<T> result = this.first;
        T res = result.date;
        this.first = this.first.next;
        this.size--;
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;
            private Node<T> firstNode = first;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return pos < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> tmp = firstNode;
                this.firstNode = tmp.next;
                pos++;
                return tmp.date;
            }
        };
    }
}
