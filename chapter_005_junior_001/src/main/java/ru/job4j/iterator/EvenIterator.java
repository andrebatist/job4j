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
        int tmp = this.index;
        do {
            tmp++;
        } while (tmp != this.values.length && values[tmp] % 2 != 0);
        return tmp != this.values.length;
    }

    @Override
    public Object next() {
        do {
            this.index++;
        } while (this.index != this.values.length && values[this.index] % 2 != 0);
        if (this.index == this.values.length) {
            throw new NoSuchElementException();
        }
        return values[index];
    }

}
