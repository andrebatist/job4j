package ru.job4j.loop;

/**
 * Подсчет суммы чётных чисел в диапазоне.
 */
public class Counter {
    /**
     * @param start  начало диапазона.
     * @param finish конец диапазона.
     * @return сумма четных чисел в диапазоне.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
