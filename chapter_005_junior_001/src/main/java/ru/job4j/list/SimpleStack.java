package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 20.02.2019
 */
public class SimpleStack<T> {

    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();


    public void push(T value) {
        list.add(value);
    }


    public T poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
