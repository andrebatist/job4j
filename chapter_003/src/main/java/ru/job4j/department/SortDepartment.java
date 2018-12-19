package ru.job4j.department;

import java.util.*;

public class SortDepartment {
    public List<Department> sortDepartmentsAsc(List<Department> departments) {
        departments = new ArrayList(addElements(departments));
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return departments;
    }

    public List<Department> sortDepartmentsDesc(List<Department> departments) {
        departments = new ArrayList(addElements(departments));
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                int result;
                if (o1.getName().length() == o2.getName().length()) {
                    result = o2.getName().compareTo(o1.getName());
                } else {
                    int size = Math.min(o1.getName().length(), o2.getName().length());
                    String first = o1.getName().substring(0, size);
                    String second = o2.getName().substring(0, size);
                    if (first.compareTo(second) == 0 && o1.getName().length() > o2.getName().length()) {
                        result = 1;
                    } else if (first.compareTo(second) == 0 && o1.getName().length() < o2.getName().length()) {
                        result = -1;
                    } else {
                        result = o2.getName().compareTo(o1.getName());
                    }
                }
                return result;
            }
        });
        return departments;
    }

    public List<Department> addElements(List<Department> departments) {
        List<Department> list = new ArrayList<>(departments);
        ListIterator<Department> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (!department.getName().contains("\\")) {
                continue;
            }
            String prevStr = getPrevDepartmentString(department);
            if (!isPrevDepartmentExists(list, prevStr)) {
                iterator.add(new Department(prevStr));
            }
        }
        return list;
    }

    private boolean isPrevDepartmentExists(List<Department> list, String prevStr) {
        for (Department tmp : list) {
            if (tmp.getName().equals(prevStr)) {
                return true;
            }
        }
        return false;
    }

    private String getPrevDepartmentString(Department department) {
        String[] arr = department.getName().split("\\\\");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 2) {
                sb.append("\\");
            }
        }
        return sb.toString();
    }
}
