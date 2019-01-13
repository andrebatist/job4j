package ru.job4j.java10;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 13.01.2019
 */
public class StudData {
    /**
     * Возвращает список студентов с баллом больше bound.
     *
     * @param students Список студентов.
     * @param bound    Граница баллов.
     * @return Спиок студентов.
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        Collections.sort(students, new Student());
        return students.stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toList())
                .stream()
                .takeWhile(stud -> stud.getScope() > bound)
                .collect(Collectors.toList());
    }
}
