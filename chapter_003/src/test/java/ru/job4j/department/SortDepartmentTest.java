package ru.job4j.department;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 20.12.2018
 */
public class SortDepartmentTest {
    /**
     * Тест на сортировку по возрастанию.
     */
    @Test
    public void whenSortDepsAsc() {
        List deps = List.of(
                new Department("K1\\SK1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        SortDepartment sortDepartment = new SortDepartment();
        List result = sortDepartment.sortDepartmentsAsc(deps);
        List expect = List.of(
                new Department("K1"),
                new Department("K1\\SK1"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K1\\SK2"),
                new Department("K2"),
                new Department("K2\\SK1"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        assertThat(result, is(expect));
    }

    /**
     * Тест на сортировку по убыванию.
     */
    @Test
    public void whenSortDepsDesc() {
        List deps = List.of(
                new Department("K1\\SK1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2")
        );
        SortDepartment sortDepartment = new SortDepartment();
        List result = sortDepartment.sortDepartmentsDesc(deps);
        List expect = List.of(
                new Department("K2"),
                new Department("K2\\SK1"),
                new Department("K2\\SK1\\SSK2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K1"),
                new Department("K1\\SK2"),
                new Department("K1\\SK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K1\\SK1\\SSK1")
        );
        assertThat(result, is(expect));
    }
}