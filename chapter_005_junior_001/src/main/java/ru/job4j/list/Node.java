package ru.job4j.list;

/**
 * Звено односвязного списка.
 *
 * @param <T> Тип элемента звена.
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 18.03.2019
 */
public class Node<T> {
    private T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}
