package ru.job4j.array;

import java.util.Arrays;

/**
 * Удаление дубликатов в массиве..
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 26.10.2018
 */
public class ArrayDuplicate {
    /**
     * Метод удаляет дубликаты в массиве.
     *
     * @param array Массив String.
     * @return Массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int l = array.length - 1;
        int doubleCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[k].equals(array[i])) {
                    String tmp = array[k];
                    array[k] = array[l];
                    array[l] = tmp;
                    l--;
                    doubleCount++;
                    break;
                }
            }
        }
        array = Arrays.copyOf(array, array.length - doubleCount);
        return array;
    }
}
