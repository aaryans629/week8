package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    private String type;
    private double amount;

    public PaymentMethod(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public abstract double calculateAdjustedAmount();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) {
        super("CARD", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return getAmount() * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) {
        super("WALLET", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return getAmount() * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) {
        super("BANKTRANSFER", amount);
    }

    @Override
    public double calculateAdjustedAmount() {
        return getAmount();
    }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int n = scanner.nextInt();
        List<PaymentMethod> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            PaymentMethod payment;
            if (type.equalsIgnoreCase("CARD")) {
                payment = new CardPayment(amount);
            } else if (type.equalsIgnoreCase("WALLET")) {
                payment = new WalletPayment(amount);
            } else {
                payment = new BankTransferPayment(amount);
            }
            transactions.add(payment);
        }

        double total = 0.0;
        for (PaymentMethod p : transactions) {
            double adjusted = p.calculateAdjustedAmount();
            System.out.printf("%s: %.2f%n", p.getType(), adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}
