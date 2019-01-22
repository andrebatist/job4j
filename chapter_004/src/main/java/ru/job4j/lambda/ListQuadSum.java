package ru.job4j.lambda;

import java.util.List;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 22.01.2019
 */
public class ListQuadSum {
    /**
     * Сумма четных вознесенных в квадрат чисел.
     *
     * @param list Список чисел.
     * @return Сумма.
     */
    public int getSumQuadro(List<Integer> list) {
        return list.stream()
                .filter(val -> val % 2 == 0)
                .map(n -> n * n)
                .reduce((val1, val2) -> val1 + val2)
                .orElse(0);
    }
}
