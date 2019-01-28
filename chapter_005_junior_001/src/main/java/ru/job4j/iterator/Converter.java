package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> it2 = it.next();
            while (it2.hasNext()) {
                list.add(it2.next());
            }
        }
        return list.iterator();
    }

}
