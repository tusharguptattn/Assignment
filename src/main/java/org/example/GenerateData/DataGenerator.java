package org.example.GenerateData;

import org.example.Entity.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    public static List<Employee> generateEmployees(int count) {
        return  IntStream.range(1, count + 1)
                .mapToObj(i -> new Employee(i, "Employee" + i,
                        i % 2 == 0 ? "IT" : "HR",
                        30000 + (i * 1000),
                        i % 5 != 0))  // Some inactive
                .collect(Collectors.toList());
    }
}
