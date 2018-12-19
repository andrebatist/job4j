package ru.job4j.department;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SortDepartmentTest {
    @Test
    public void whenSortDepsAsc() {
        List deps = Arrays.asList(
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
        System.out.println(result);
    }

    @Test
    public void whenSortDepsDesc() {
        List deps = Arrays.asList(
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
        System.out.println(result);
    }
}