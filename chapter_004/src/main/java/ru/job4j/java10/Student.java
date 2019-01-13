package ru.job4j.java10;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 13.01.2019
 */
public class Student implements Comparator<Student> {
    /**
     * Имя.
     */
    private String name;

    /**
     * Балл.
     */
    private int scope;

    /**
     * Сравнение двух студентов по убыванию баллов и в библиографическом порядке.
     *
     * @param o1 Первый студент.
     * @param o2 Второй студент.
     * @return Результат сравнения.
     */
    @Override
    public int compare(Student o1, Student o2) {
        if ((o1 == null) || (o2 == null)) {
            return 0;
        }
        int res = Integer.compare(o2.getScope(), o1.getScope());
        return res != 0 ? res : o1.getName().compareTo(o2.getName());
    }

    public Student() {

    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getScope() == student.getScope()
                && Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScope());
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='"
                + name
                + '\''
                + ", scope="
                + scope
                + '}';
    }
}
