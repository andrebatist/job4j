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
     * Тест на список из трех пользователей по возрасту.
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

    /**
     * Тест на список из 5 пользователей сортировка по длине имени.
     */
    @Test
    public void when5UsersSortByNameLength() {
        User user = new User("Frank", 25);
        User user2 = new User("Michael", 25);
        User user3 = new User("Fedor", 15);
        User user4 = new User("Ivan", 11);
        User user5 = new User("Petr", 30);
        List<User> users = new ArrayList<>(Arrays.asList(user, user2, user3, user4, user5));
        List result = new SortUser().sortNameLength(users);
        List expect = new ArrayList(Arrays.asList(user4, user5, user, user3, user2));
        assertThat(result, is(expect));
    }

    /**
     * Тест на список из 4 пользователей сортировка по имени и возрасту.
     */
    @Test
    public void when4UsersSortByAllFields() {
        User user = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        List<User> users = new ArrayList<>(Arrays.asList(user, user2, user3, user4));
        List result = new SortUser().sortByAllFields(users);
        List expect = new ArrayList(Arrays.asList(user4, user2, user3, user));
        assertThat(result, is(expect));
    }
}