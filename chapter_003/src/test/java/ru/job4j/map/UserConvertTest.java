package ru.job4j.map;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 5.12.2018
 */
public class UserConvertTest {
    /**
     * Тест на список из двух пользователей.
     */
    @Test
    public void when2IntArraysThen1res() {
        UserConvert convert = new UserConvert();
        List<User> sample = List.of(
                new User(1, "Victor", "Berlin"),
                new User(2, "Deni", "Paris")
        );
        Map<Integer, User> result = convert.process(sample);
        Map<Integer, User> expect = Map.of(
                1, new User(1, "Victor", "Berlin"),
                2, new User(2, "Deni", "Paris")
        );
        assertThat(result, is(expect));
    }
}