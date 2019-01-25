package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 24.01.2019
 */
public class EvenIterator implements Iterator {

    private final int[] values;

    private int index;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean res = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                res = true;
                index = i;
                break;
            }
        }
        return res;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }

}
