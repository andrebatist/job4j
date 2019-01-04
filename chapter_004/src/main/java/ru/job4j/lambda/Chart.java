package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 4.01.2019
 */
public class Chart {
    /**
     * Подсчет значений функции в диапазоне.
     *
     * @param start Начало диапазона.
     * @param end   Конец диапазона.
     * @param func  Функция.
     * @return Значения функции.
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> values = new ArrayList<>();
        for (int i = start; i != end; i++) {
            values.add(func.apply((double) i));
        }
        return values;
    }
}
