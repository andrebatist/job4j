package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 3.12.2018
 */
public class ConvertMatrix2List {
    /**
     * Возвращает список из 2D матрицы.
     *
     * @param array Исходный массив.
     * @return Список чисел.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] nums : array) {
            for (int elem : nums) {
                list.add(elem);
            }
        }
        return list;
    }
}
