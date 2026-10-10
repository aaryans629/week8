package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TransportJourney {
    private String type;
    private double distance;

    public TransportJourney(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public double getDistance() {
        return distance;
    }

    public abstract double calculateFare();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * getDistance());
        return Math.min(10.0, fare);
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * getDistance());
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    public double getPeakHourFactor() {
        return peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * getDistance())) * peakHourFactor;
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<TransportJourney> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();

            TransportJourney journey;
            if (type.equalsIgnoreCase("BUS")) {
                journey = new BusJourney(distance);
            } else if (type.equalsIgnoreCase("TRAIN")) {
                journey = new TrainJourney(distance);
            } else {
                double peakHourFactor = scanner.nextDouble();
                journey = new MetroJourney(distance, peakHourFactor);
            }
            journeys.add(journey);
        }

        double total = 0.0;
        for (TransportJourney j : journeys) {
            double fare = j.calculateFare();
            System.out.printf("%s: %.2f%n", j.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
