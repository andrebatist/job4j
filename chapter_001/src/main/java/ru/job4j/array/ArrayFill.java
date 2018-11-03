package ru.job4j.array;

/**
 * Сортировка двух отсортированных в отдельности массивов.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 30.10.2018
 */
public class ArrayFill {
    /**
     * Метод возвращает один массив из двух отсортированных.
     *
     * @param first  Первый массив.
     * @param second Второй массив.
     * @return отсортированный массив.
     */
    public int[] fill(int[] first, int[] second) {
        int minFirst = getMinValueFromArray(first);
        int minSecond = getMinValueFromArray(second);
        int[] res = new int[first.length + second.length];
        if (minFirst < minSecond) {
            fillResArray(first, second, res);
        } else {
            fillResArray(second, first, res);
        }
        return res;
    }

    /**
     * Метод заполняет результиующий массив
     *
     * @param first  Первый массив.
     * @param second Второй массив.
     * @param res    Итоговый массив.
     */
    private void fillResArray(int[] first, int[] second, int[] res) {
        int k = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] < second[i]) {
                if (i == 0) {
                    res[i] = first[i];
                    res[i + 1] = second[i];
                } else {
                    k++;
                    res[i + k] = first[i];
                    res[i + k + 1] = second[i];
                }
            }
        }
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
