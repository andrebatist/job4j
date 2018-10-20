package ru.job4j.max;

/**
 * Максимум из двух  и трех чисел.
 */
public class Max {
    /**
     * Максимум из двух чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @return Маскимум из двух чисел.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Максимум из трех чисел.
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third  Третье число.
     * @return Максимум из трех чисел.
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
