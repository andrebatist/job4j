package ru.job4j.java10;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 13.01.2019
 */
public class StudDataTest {
    /**
     * Тест со списком студентов и пустыми значениями.
     */
    @Test
    public void whenListOfStudentsWithNullThenGetStudentsWithBiggerBound() {
        StudData studData = new StudData();
        List<Student> students = Arrays.asList(
                new Student("Victor", 2),
                new Student("Pavel", 5),
                null,
                new Student("Anton", 5),
                null,
                new Student("Alex", 4)
        );
        List<Student> result = studData.levelOf(students, 4);
        List expect = Arrays.asList(
                new Student("Anton", 5),
                new Student("Pavel", 5)
        );
        assertThat(result, is(expect));
    }
}