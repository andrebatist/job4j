package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерерфейс SimpleTree
 *
 * @param <T> Тип элементов дерева
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.05.2019
 */
public interface SimpleTree<T> extends Iterable<T> {
    boolean add(T parent, T child);

    Optional<Node<T>> findBy(T value);
}
