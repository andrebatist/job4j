package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 5.02.2019
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }

    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
        E date = this.first.date;
        this.first = this.first.next;
        return date;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    public int getSize() {
        return this.size;
    }
}
