package ru.job4j.array;

/**
 * Двумерный массив. True или false по диагоналям.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 25.10.2018
 */
public class MatrixCheck {
    /**
     * Метод проверяет дианонали матрицы true или false.
     *
     * @param data двумерный массив.
     * @return true или false.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if ((i == j) || ((i + j) == data.length - 1)) {
                    if (!data[i][j]) {
                        result = false;
                        break;
                    }
                }

            }
        }
        return result;
    }
}
