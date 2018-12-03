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
        while (tmp.size() % rows != 0) {
            tmp.add(0);
        }
        int cells = tmp.size() / rows;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                array[i][j] = tmp.get(count);
                count++;
            }
        }
        return array;
    }
}
