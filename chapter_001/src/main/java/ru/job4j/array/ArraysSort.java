package ru.job4j.array;

import java.util.Arrays;

/**
 * Сортировка двух отсортированных в отдельности массивов.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class ArraysSort {
    /**
     * Метод сортирует два отсортированных массива.
     *
     * @param first  Первый массив.
     * @param second Второй массив.
     * @return отсортированный массив.
     */
    public int[] sort(int[] first, int[] second) {
        int minFirst = getMinValueFromArray(first);
        int minSecond = getMinValueFromArray(second);
        int[] res;
        int k = 0;
        if (minFirst < minSecond) {
            res = Arrays.copyOf(first, first.length + second.length);
            for (int i = first.length; i < res.length; i++) {
                res[i] = second[k];
                k++;
            }
        } else {
            res = Arrays.copyOf(second, second.length + first.length);
            for (int i = second.length; i < res.length; i++) {
                res[i] = first[k];
                k++;
            }
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(res);
        return res;
    }

    /**
     * Метод находит минимальный элемент в массиве.
     *
     * @param arr Входящий массив.
     * @return Минимальный элемент.
     */
    private int getMinValueFromArray(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return arr[minIndex];
    }
}
