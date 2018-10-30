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
     * @param firstArr  Первый массив.
     * @param secondArr Второй массив.
     * @return отсортированный массив.
     */
    public int[] sortArrays(int[] firstArr, int[] secondArr) {
        int minElFirst = getMinValueFromArray(firstArr);
        int minElSecond = getMinValueFromArray(secondArr);
        int[] resArray;
        int k = 0;
        if (minElFirst < minElSecond) {
            resArray = Arrays.copyOf(firstArr, firstArr.length + secondArr.length);
            for (int i = firstArr.length; i < resArray.length; i++) {
                resArray[i] = secondArr[k];
                k++;
            }
        } else {
            resArray = Arrays.copyOf(secondArr, secondArr.length + firstArr.length);
            for (int i = secondArr.length; i < resArray.length; i++) {
                resArray[i] = firstArr[k];
                k++;
            }
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(resArray);
        return resArray;
    }

    /**
     * Метод находит минимальный элемент в массиве.
     *
     * @param arr Входящий массив.
     * @return Минимальный элемент.
     */
    private int getMinValueFromArray(int[] arr) {
        int indexOfMin = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[indexOfMin]) {
                indexOfMin = i;
            }
        }
        return arr[indexOfMin];
    }
}
