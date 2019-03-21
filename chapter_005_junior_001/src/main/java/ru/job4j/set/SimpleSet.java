package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 21.03.2019
 */
public class SimpleSet<T> implements Iterable<T> {
    private DynamicArray<T> set = new DynamicArray<>();

    public boolean add(T value) {
        for (T val : set) {
            if (val.equals(value)) {
                return false;
            }
        }
        set.add(value);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
