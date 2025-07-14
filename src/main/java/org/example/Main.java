package org.example;

import org.example.Entity.Employee;
import org.example.GenerateData.DataGenerator;
import org.example.Service.PayrollService;
import org.example.Utility.EmployeeUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = DataGenerator.generateEmployees(20);

        System.out.println("All Employees:");
        employees.stream().map(i->i.getName()).forEach(System.out::println);

        List<Employee> activeEmployees = EmployeeUtil.filterActiveEmployees(employees);
        System.out.println("\nActive Employees:");
        activeEmployees.stream().map(i->i.getName()).forEach(System.out::println);

        double avgSalary = EmployeeUtil.calculateAverageSalary(activeEmployees);
        System.out.println("\nAverage Salary: " + avgSalary);

        List<String> sortedNames = EmployeeUtil.getEmployeeNamesSorted(activeEmployees);
        System.out.println("\nSorted Employee Names:");
        sortedNames.forEach(System.out::println);

        System.out.println("\nProcessing payrolls concurrently...");
        PayrollService service = new PayrollService();
        service.processPayrolls(activeEmployees);
        }
    }