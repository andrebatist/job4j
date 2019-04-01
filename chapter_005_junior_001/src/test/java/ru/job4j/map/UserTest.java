package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 26.03.2019
 */
public class UserTest {

    @Test
    public void whenPutTwoSameObjectsThenCollision() {
        Calendar calendar = new GregorianCalendar(1978, 3, 25);
        User userOne = new User("Fedor", 2, calendar);
        User userTwo = new User("Fedor", 2, calendar);
        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(userOne, "First");
        userObjectMap.put(userTwo, "Second");
        System.out.println(userObjectMap);
        assertThat(userObjectMap.size(), is(1));
    }
}