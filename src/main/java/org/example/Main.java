package org.example;

import org.example.Entity.Employee;
import org.example.GenerateData.DataGenerator;
import org.example.Service.PayrollService;
import org.example.Utility.EmployeeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var employees = DataGenerator.generateEmployees(20);

        System.out.println("All Employees:");
        employees.stream().map(i->i.getName()).forEach(System.out::println);

        List<Employee> activeEmployees = EmployeeUtil.filterActiveEmployees(employees);
        System.out.println("\nActive Employees:");
        activeEmployees.stream().map(i->i.getName()).forEach(System.out::println);

        var avgSalary = EmployeeUtil.calculateAverageSalary(activeEmployees);
        System.out.println("\nAverage Salary: " + avgSalary);

        var sortedNames = EmployeeUtil.getEmployeeNamesSorted(activeEmployees);
        System.out.println("\nSorted Employee Names:");
        sortedNames.forEach(System.out::println);

        System.out.println("\nProcessing payrolls concurrently...");
        var service = new PayrollService();
        service.processPayrolls(activeEmployees);


    /// //// Java 11and 12 Features
//        String str = "Line1\nLine2\nLine3";
//        str.lines().filter(s -> s.contains("1")).forEach(System.out::println);
//        str.lines().forEach(System.out::println);
//        System.out.println("    heloo    ".strip());
//        System.out.println("    heloo    ".stripLeading());
//        System.out.println("    heloo    ".stripTrailing());

//        System.out.println("Hello, World!".repeat(3));
//        System.out.println("  ".isBlank());


        /// ///// Java 9 Features

//        List<String> list = List.of("A", "B", "C");
//        Set<Integer> set = Set.of(1, 2, 3);
//        Map<String, Integer> map = Map.of("a", 1, "b", 2);


        // takeWhile example
//        List<Integer> list = List.of(1, 2, 3, 4, 5, 0, 6);
//        list.stream()
//                .takeWhile(n -> n > 0)
//                .forEach(System.out::println); // Output: 1 2 3 4 5


        // dropWhile example
//        list.stream()
//                .dropWhile(n -> n < 4)
//                .forEach(System.out::println); // Output: 4 5 0 6

// ofNullable example
//        Stream<String> stream = Stream.ofNullable(null); // returns empty stream


        /// /// java 10 Features

        // var keyword example
        // Note: 'var' can only be used for local variables, not class fields or method parameters.

//        var name = "Sheru";     // inferred as String
//        var count = 10;         // inferred as int
//        var list = List.of("a","b");// inferred as ArrayList<String>
//        System.out.println("Name: " + name);
//        System.out.println("Count: " + count);
//        System.out.println("List: " + list);



    }
    }