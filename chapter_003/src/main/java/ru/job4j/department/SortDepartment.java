package ru.job4j.department;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDepartment {
    public List<Department> sortDepartmentsAsc(List<Department> departments) {
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return departments;
    }

    public List<Department> sortDepartmentsDesc(List<Department> departments) {
        departments.sort(Collections.reverseOrder(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }));
        //Collections.reverseOrder(departments);
        return departments;
    }
}
