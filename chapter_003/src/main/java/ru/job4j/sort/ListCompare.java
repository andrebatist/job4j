package ru.job4j.sort;

import java.util.Comparator;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 8.12.2018
 */
public class ListCompare implements Comparator<String> {
    /**
     * Возвращает результат сравнения двух строк.
     *
     * @param o1 Первая строка.
     * @param o2 Вторая строка.
     * @return Результат сравнения.
     */
    @Override
    public int compare(String o1, String o2) {
        int maxSize = o1.length() > o2.length() ? o2.length() : o1.length();
        for (int i = 0; i < maxSize; i++) {
            int res = Character.compare(o1.charAt(i), o2.charAt(i));
            if (res != 0) {
                return res;
            }
        }
        return o1.length() - o2.length();
    }
}
