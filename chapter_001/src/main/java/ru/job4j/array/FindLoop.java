package ru.job4j.array;

/**
 * Поиск числа перебором.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 23.10.2018
 */
public class FindLoop {
    /**
     * Метод возвращает индекс элемента в массиве.
     *
     * @param data Массив чисел.
     * @param el   Элемент.
     * @return Индекс элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}
