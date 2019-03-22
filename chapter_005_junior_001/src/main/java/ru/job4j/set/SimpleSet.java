package ru.job4j.set;

import ru.job4j.list.DynamicArray;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 21.03.2019
 */
public class SimpleSet<T> implements Iterable<T> {
    private DynamicArray<T> set = new DynamicArray<>();

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
        for (T val : set) {
            if (Objects.equals(val, value)) {
                return false;
            }
        }
        return true;
    }
}
