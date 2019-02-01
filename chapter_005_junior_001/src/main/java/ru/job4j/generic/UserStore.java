package ru.job4j.generic;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 31.01.2019
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(SimpleArray<User> values) {
        super(values);
    }
}
