package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 28.01.2019
 */
public class Converter {
    /**
     * Возвращает итератор целых чисел.
     *
     * @param it Итератор из итераторов.
     * @return Итератор.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> inner = it.next();

            @Override
            public boolean hasNext() {
                if (inner.hasNext()) {
                    return true;
                } else {
                    if (!it.hasNext()) {
                        return false;
                    }
                    inner = it.next();
                    if (inner.hasNext()) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inner.next();
            }
        };
    }

}
