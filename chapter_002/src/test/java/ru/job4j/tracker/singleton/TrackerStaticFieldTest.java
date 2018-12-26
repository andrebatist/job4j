package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version 0.1
 * @since 26.12.2018
 */
public class TrackerStaticFieldTest {
    /**
     * Тест на равенство двух объектов.
     */
    @Test
    public void whenTwoTrackerAreEqual() {
        TrackerStaticField first = TrackerStaticField.getInstance();
        TrackerStaticField second = TrackerStaticField.getInstance();
        assertThat(first, is(second));
    }
}