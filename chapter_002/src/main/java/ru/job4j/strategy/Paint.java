package ru.job4j.strategy;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 10.11.2018
 */
public class Paint {
    /**
     * Метод печатает на экране фигуру.
     *
     * @param shape Фигура.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
