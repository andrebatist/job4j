package ru.job4j.sort;

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
}
