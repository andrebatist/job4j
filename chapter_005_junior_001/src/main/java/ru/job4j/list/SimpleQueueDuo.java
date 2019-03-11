package ru.job4j.list;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 11.03.2019
 */
public class SimpleQueueDuo<T> {
    private final SimpleStack<T> stackIn = new SimpleStack<>();
    private final SimpleStack<T> stackOut = new SimpleStack<>();

    public void push(T value) {
        stackIn.push(value);
    }

    public T poll() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.poll());
            }
        }
        return stackOut.poll();
    }
}
