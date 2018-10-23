package ru.job4j.array;

/**
 * Поиск числа перебором.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 23.10.2018
 */
public class Turn {
    /**
     * Метод переворачивает массив.
     *
     * @param array Исходный массив.
     * @return Перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
}
