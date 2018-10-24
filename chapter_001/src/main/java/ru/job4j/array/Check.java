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
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
