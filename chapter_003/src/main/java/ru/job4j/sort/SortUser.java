package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 7.12.2018
 */
public class SortUser {
    /**
     * Возвращает отсортированный по возрасту по возрастанию набор пользователей.
     *
     * @param users Список пользователей.
     * @return Набор пользователей.
     */
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    /**
     * Возвращает отсортированный по длине имени по возрастанию список пользователей.
     *
     * @param users Список пользователей.
     * @return Отсортированный список.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    /**
     * Возвращает отсортированный по имени и возрасту по возрастанию список пользователей.
     *
     * @param users Список пользователей.
     * @return Отсортированный список.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int res = o1.getName().compareTo(o2.getName());
                return res != 0 ? res : o1.compareTo(o2);
            }
        });
        return users;
    }
}
