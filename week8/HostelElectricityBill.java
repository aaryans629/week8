package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {

    public static abstract class Room {
        protected String type;
        protected int units;

        public Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        public abstract double calculateBill();

        public String getType() {
            return type;
        }
    }

    public static class SingleRoom extends Room {
        public SingleRoom(int units) {
            super("SINGLE", units);
        }

        @Override
        public double calculateBill() {
            return units * 8.0;
        }
    }

    public static class SharedRoom extends Room {
        private int occupants;

        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = Math.max(1, occupants);
        }

        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    public static class AcRoom extends Room {
        public AcRoom(int units) {
            super("AC", units);
        }

        @Override
        public double calculateBill() {
            return (units * 10.0) + 200.0;
        }
    }

    public static void processRooms(List<Room> rooms) {
        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }

    public static void main(String[] args) {
        String sampleInput = "3\nSINGLE 120\nSHARED 150 3\nAC 100";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            if ("SINGLE".equalsIgnoreCase(type)) {
                rooms.add(new SingleRoom(units));
            } else if ("SHARED".equalsIgnoreCase(type)) {
                int occupants = Integer.parseInt(parts[2]);
                rooms.add(new SharedRoom(units, occupants));
            } else if ("AC".equalsIgnoreCase(type)) {
                rooms.add(new AcRoom(units));
            }
        }
        scanner.close();

        processRooms(rooms);
    }
}
