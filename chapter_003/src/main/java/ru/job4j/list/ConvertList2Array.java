package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 3.12.2018
 */
public class ConvertList2Array {
    /**
     * Возвращает двумерный массив из списка целых чисел.
     *
     * @param list Исходный список.
     * @param rows Количество строк массива.
     * @return Двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        List<Integer> tmp = new ArrayList<>(list);
        int[][] array = new int[rows][rows];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (count < tmp.size()) {
                    array[i][j] = tmp.get(count);
                    count++;
                } else {
                    break;
                }
            }
        }
        return array;
    }
}
