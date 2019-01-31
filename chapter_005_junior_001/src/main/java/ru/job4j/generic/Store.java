package ru.job4j.generic;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 31.01.2019
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
