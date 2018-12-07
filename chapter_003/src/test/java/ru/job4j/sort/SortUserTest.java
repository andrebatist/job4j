package ru.job4j.sort;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 7.12.2018
 */
public class SortUserTest {
    /**
     * Тест на список из трех пользователей.
     */
    @Test
    public void when3Users() {
        User user = new User("Frank", 33);
        User user2 = new User("Victor", 25);
        User user3 = new User("Fedor", 15);
        List<User> users = new ArrayList<>(Arrays.asList(user, user2, user3));
        Set result = new SortUser().sort(users);
        Set expect = new TreeSet(Arrays.asList(user3, user2, user));
        assertThat(result, is(expect));
    }
}