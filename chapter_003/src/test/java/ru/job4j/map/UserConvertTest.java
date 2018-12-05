package ru.job4j.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        List<User> sample = new ArrayList<>();
        sample.add(new User(1, "Victor", "Berlin"));
        sample.add(new User(2, "Deni", "Paris"));
        HashMap<Integer, User> result = convert.process(sample);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "Victor", "Berlin"));
        expect.put(2, new User(2, "Deni", "Paris"));
        assertThat(result, is(expect));
    }
}