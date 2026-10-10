package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CampusParkingChargeCalculator {

    public static abstract class Vehicle {
        protected String type;
        protected int hours;

        public Vehicle(String type, int hours) {
            this.type = type;
            this.hours = hours;
        }

        public abstract double calculateCharge();

        public String getType() {
            return type;
        }
    }

    public static class Bike extends Vehicle {
        public Bike(int hours) {
            super("BIKE", hours);
        }

        @Override
        public double calculateCharge() {
            return hours * 10.0;
        }
    }

    public static class Car extends Vehicle {
        public Car(int hours) {
            super("CAR", hours);
        }

        @Override
        public double calculateCharge() {
            if (hours <= 1) {
                return 30.0;
            } else {
                return 30.0 + (hours - 1) * 20.0;
            }
        }
    }

    public static class Truck extends Vehicle {
        public Truck(int hours) {
            super("TRUCK", hours);
        }

        @Override
        public double calculateCharge() {
            double charge = hours * 50.0;
            return Math.max(100.0, charge);
        }
    }

    public static void processVehicles(List<Vehicle> vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        String sampleInput = "4\nBIKE 3\nCAR 4\nTRUCK 1\nCAR 1";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            if ("BIKE".equalsIgnoreCase(type)) {
                vehicles.add(new Bike(hours));
            } else if ("CAR".equalsIgnoreCase(type)) {
                vehicles.add(new Car(hours));
            } else if ("TRUCK".equalsIgnoreCase(type)) {
                vehicles.add(new Truck(hours));
            }
        }
        scanner.close();

        processVehicles(vehicles);
    }
}
