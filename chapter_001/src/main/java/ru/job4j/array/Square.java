package ru.job4j.array;

/**
 * Заполнение массива степенями чисел.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 22.10.2018
 */
public class Square {
    /**
     * Метод возвращает массив со степенями чисел.
     *
     * @param bound количество элементов.
     * @return массив со степенями чисел.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            int k = i + 1;
            rst[i] = k * k;
        }
        return rst;
    }
}
