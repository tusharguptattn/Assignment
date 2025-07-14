package org.example.Utility;

import org.example.Entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtil {

    public static List<Employee> filterActiveEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(Employee::isActive)
                .collect(Collectors.toList());
    }

    public static double calculateAverageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    public static List<String> getEmployeeNamesSorted(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
