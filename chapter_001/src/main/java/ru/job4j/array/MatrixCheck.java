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
            if ((data[0][0] != data[i][i]) || (data[0][data.length - 1] != data[i][data.length - 1 - i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
