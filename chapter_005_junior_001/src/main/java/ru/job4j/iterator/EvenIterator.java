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

    private int index = -1;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return getEvenValue(this.index) != this.values.length;
    }

    @Override
    public Object next() {
        this.index = getEvenValue(this.index);
        if (this.values.length == 0 || this.index == this.values.length) {
            throw new NoSuchElementException();
        }
        return values[index];
    }

    private int getEvenValue(int tmp) {
        do {
            tmp++;
        } while (tmp != this.values.length && values[tmp] % 2 != 0);
        return tmp;
    }

}
