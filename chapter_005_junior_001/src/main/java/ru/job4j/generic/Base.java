package ru.job4j.generic;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 31.01.2019
 */
public abstract class Base {
    private final String id;

    public Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
