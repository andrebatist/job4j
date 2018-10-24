package ru.job4j.array;

/**
 * Массив заполнен true или false.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 24.10.2018
 */
public class Check {
    /**
     * Метод проверяет заполнен массив true или false.
     *
     * @param data Массив boolean.
     * @return true или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        int s = 0;
        int k = 0;
        for (boolean el : data) {
            if (el) {
                s++;
            } else {
                k++;
            }
        }
        if ((s == data.length) || (k == data.length)) {
            result = true;
        }
        return result;
    }
}
