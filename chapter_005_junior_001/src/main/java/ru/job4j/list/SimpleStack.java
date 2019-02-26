package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 20.02.2019
 */
public class SimpleStack<T> {

    private SingleLinkedList<T> stack = new SingleLinkedList<>();

    public void setStack(SingleLinkedList<T> stack) {
        this.stack = stack;
    }

    public SingleLinkedList<T> getStack() {
        return stack;
    }

    public int getSize() {
        return stack.getSize();
    }

    public T poll() {
        return stack.delete();
    }

    public void push(T date) {
        stack.add(date);
    }
}
