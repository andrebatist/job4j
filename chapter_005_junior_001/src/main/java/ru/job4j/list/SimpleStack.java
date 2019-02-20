package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 20.02.2019
 */
public class SimpleStack<T> {
    private int size;
    private SimpleStack.Node<T> first;

    public int getSize() {
        return size;
    }

    private static class Node<T> {
        T date;
        SimpleStack.Node<T> next;

        Node(T date) {
            this.date = date;
        }
    }

    public T poll() {
        SimpleStack.Node<T> result = this.first;
        T res = result.date;
        this.first = this.first.next;
        this.size--;
        return res;
    }

    public void push(T date) {
        SimpleStack.Node<T> newLink = new SimpleStack.Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }
}
