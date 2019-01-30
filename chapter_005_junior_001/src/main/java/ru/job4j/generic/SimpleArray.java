package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 30.01.2019
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;

    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void remove(int index) {
        System.arraycopy(this.objects, index + 1, this.objects, index, this.index - index + 1);
        this.index--;
    }

    public Object get(int index) {
        return this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return objects.length > pos;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[pos++];
            }
        };
    }
}
