package org.example.Service;

import org.example.Entity.Employee;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PayrollService {

    public void processPayrolls(List<Employee> employees) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        employees.forEach(emp -> {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() +
                        " processing payroll for: " + emp.getName());
                try {
                    Thread.sleep(100); // Simulate time-consuming operation
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        executor.shutdown();
    }
}
