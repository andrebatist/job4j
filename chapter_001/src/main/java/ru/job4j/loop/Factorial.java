package ru.job4j.loop;

/**
 * Подсчет факториала.
 */
public class Factorial {
    /**
     * Метод для подсчета факториала.
     *
     * @param n Положительное целое число.
     * @return Факториал числа.
     */
    public int calc(int n) {
        int fac = 1;
        if (n == 0) {
            return fac;
        }
        for (int i = 1; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }
}
