package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 8.02.2019
 */
public class DynamicArray<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    private int capacity = 10;
    private int index = 0;
    private int modCount = 0;

    public Object[] getContainer() {
        return container;
    }

    public void add(T value) {
        if (index == container.length) {
            capacity *= 2;
            Object[] tmp = new Object[capacity];
            System.arraycopy(container, 0, tmp, 0, container.length);
            container = tmp;
            modCount++;
        }
        container[index++] = value;
    }

    public T get(int index) {
        return (T) container[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;
            private int nextPos = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (nextPos == container.length) {
                    return false;
                }
                return container[nextPos++] != null;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[pos++];
            }
        };
    }
}
