package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalBonusCalculator {

    public static abstract class Employee {
        protected String name;
        protected double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public abstract double calculateBonus();

        public String getName() {
            return name;
        }
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculateBonus() {
            return salary * 0.10;
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculateBonus() {
            return salary * 0.05;
        }
    }

    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double salary) {
            super(name, salary);
        }

        @Override
        public double calculateBonus() {
            return 2000.0;
        }
    }

    public static void processEmployees(List<Employee> employees) {
        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", e.getName(), bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nFULLTIME Asha 50000\nPARTTIME Ravi 30000\nINTERN Neha 15000";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            if ("FULLTIME".equalsIgnoreCase(type)) {
                employees.add(new FullTimeEmployee(name, salary));
            } else if ("PARTTIME".equalsIgnoreCase(type)) {
                employees.add(new PartTimeEmployee(name, salary));
            } else if ("INTERN".equalsIgnoreCase(type)) {
                employees.add(new InternEmployee(name, salary));
            }
        }
        scanner.close();

        processEmployees(employees);
    }
}
