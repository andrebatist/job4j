package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 18.03.2019
 */
public class LinkedListUtil {
    /**
     * Метод определяет замыкание элементов односвязного списка.
     *
     * @param first Первый узел.
     * @param <T>   Тип данных узла.
     * @return Есть или нет замыкание.
     */
    public <T> boolean isCycled(Node<T> first) {
        Node<T> one = first;
        Node<T> two = first;
        while (one != null && one.next != null) {
            one = one.next.next;
            two = two.next;
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}
