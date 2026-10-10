package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CanteenBillingCounter {

    public static abstract class Customer {
        protected String type;
        protected double amount;

        public Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public abstract double calculateFinalAmount();

        public String getType() {
            return type;
        }
    }

    public static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) {
            super("STUDENT", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.90;
        }
    }

    public static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) {
            super("STAFF", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount * 0.95;
        }
    }

    public static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) {
            super("GUEST", amount);
        }

        @Override
        public double calculateFinalAmount() {
            return amount + 10.0;
        }
    }

    public static void processBills(List<Customer> customers) {
        double total = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            total += finalAmount;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSTUDENT 200\nSTAFF 300\nGUEST 150";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            if ("STUDENT".equalsIgnoreCase(type)) {
                customers.add(new StudentCustomer(amount));
            } else if ("STAFF".equalsIgnoreCase(type)) {
                customers.add(new StaffCustomer(amount));
            } else if ("GUEST".equalsIgnoreCase(type)) {
                customers.add(new GuestCustomer(amount));
            }
        }
        scanner.close();

        processBills(customers);
    }
}
