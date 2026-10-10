package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class DeliveryRequest {
    private String type;
    private double weight;
    private double distance;

    public DeliveryRequest(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public double getDistance() {
        return distance;
    }

    public abstract double calculateFee();
}

class StandardDelivery extends DeliveryRequest {
    public StandardDelivery(double weight, double distance) {
        super("STANDARD", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 5.0 + (0.50 * getWeight()) + (0.10 * getDistance());
    }
}

class ExpressDelivery extends DeliveryRequest {
    public ExpressDelivery(double weight, double distance) {
        super("EXPRESS", weight, distance);
    }

    @Override
    public double calculateFee() {
        return 15.0 + (1.00 * getWeight()) + (0.20 * getDistance());
    }
}

class InternationalDelivery extends DeliveryRequest {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super("INTERNATIONAL", weight, distance);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    @Override
    public double calculateFee() {
        return 25.0 + (2.00 * getWeight()) + (0.50 * getDistance()) + customsFee;
    }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<DeliveryRequest> requests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();

            DeliveryRequest request;
            if (type.equalsIgnoreCase("STANDARD")) {
                request = new StandardDelivery(weight, distance);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                request = new ExpressDelivery(weight, distance);
            } else {
                double customsFee = scanner.nextDouble();
                request = new InternationalDelivery(weight, distance, customsFee);
            }
            requests.add(request);
        }

        double total = 0.0;
        for (DeliveryRequest r : requests) {
            double fee = r.calculateFee();
            System.out.printf("%s: %.2f%n", r.getType(), fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
