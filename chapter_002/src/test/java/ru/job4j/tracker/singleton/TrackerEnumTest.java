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
public class TrackerEnumTest {
    /**
     * Тест на равенство двух enum.
     */
    @Test
    public void whenTwoTrackerEnumsAreEqual() {
        TrackerEnum first = TrackerEnum.INSTANCE;
        TrackerEnum second = TrackerEnum.INSTANCE;
        assertThat(first, is(second));
    }
}