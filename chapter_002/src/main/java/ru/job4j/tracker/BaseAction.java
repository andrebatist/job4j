package ru.job4j.tracker;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 17.11.2018
 */
public abstract class BaseAction implements UserAction {
    private final int key;

    private final String name;

    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String key() {
        return String.valueOf(this.key);
    }

    @Override
    public String info() {
        return this.name;
    }
}
