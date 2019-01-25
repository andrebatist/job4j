package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 24.01.2019
 */
public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int indexI = -1;
    private int indexJ = -1;

    public MatrixIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        int i = this.indexI == -1 ? this.indexI + 1 : this.indexI;
        int j = this.indexJ == -1 ? this.indexJ + 1 : this.indexJ;
        if (i == this.values.length - 1) {
            return j + 1 < this.values[i].length;
        }
        return i < this.values.length;
    }

    @Override
    public Object next() {
        if (this.values.length == 0
                || (this.indexI == this.values.length
                || (this.indexI == this.values.length - 1
                && this.indexJ == this.values[this.values.length - 1].length))) {
            throw new NoSuchElementException();
        }
        if (this.indexI == -1 && this.indexJ == -1) {
            return values[++indexI][++indexJ];
        }
        if (this.indexJ == values[this.indexI].length - 1) {
            this.indexJ = 0;
            this.indexI++;
        } else {
            this.indexJ++;
        }
        return values[indexI][indexJ];
    }
}
