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

    private boolean isNullAdded;

    public void add(T value) {
        if (isNotDouble(value)) {
            set.add(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    private boolean isNotDouble(T value) {
        if (value == null) {
            if (!isNullAdded) {
                isNullAdded = true;
                return true;
            } else {
                return false;
            }
        }
        for (T val : set) {
            if (val != null && val.equals(value)) {
                return false;
            }
        }
        return true;
    }
}
