package ru.job4j.array;

/**
 * Двумерный массив. Таблица умножения.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 23.10.2018
 */
public class Matrix {
    /**
     * Метод возвращает двумерный массив заданного размера.
     *
     * @param size Размер двумерного массива.
     * @return Двумерный массив.
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
