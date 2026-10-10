package week8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    public static abstract class SubscriptionPlan {
        protected String name;
        protected LocalDate startDate;

        public SubscriptionPlan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        public abstract LocalDate calculateRenewalDate();

        public String getName() {
            return name;
        }
    }

    public static class BasicPlan extends SubscriptionPlan {
        public BasicPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(30);
        }
    }

    public static class StandardPlan extends SubscriptionPlan {
        public StandardPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(90);
        }
    }

    public static class PremiumPlan extends SubscriptionPlan {
        public PremiumPlan(String name, LocalDate startDate) {
            super(name, startDate);
        }

        @Override
        public LocalDate calculateRenewalDate() {
            return startDate.plusDays(365);
        }
    }

    public static void processPlans(List<SubscriptionPlan> plans) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (SubscriptionPlan plan : plans) {
            LocalDate renewalDate = plan.calculateRenewalDate();
            System.out.printf("%s: %s%n", plan.getName(), renewalDate.format(formatter));
        }
    }

    public static void main(String[] args) {
        String sampleInput = "4\nBASIC Asha 2024-01-15\nSTANDARD Ravi 2024-02-01\nPREMIUM Neha 2024-03-10\nBASIC Kiran 2024-12-20";
        Scanner scanner = new Scanner(sampleInput);

        int n = Integer.parseInt(scanner.nextLine().trim());
        List<SubscriptionPlan> plans = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2], formatter);

            if ("BASIC".equalsIgnoreCase(type)) {
                plans.add(new BasicPlan(name, startDate));
            } else if ("STANDARD".equalsIgnoreCase(type)) {
                plans.add(new StandardPlan(name, startDate));
            } else if ("PREMIUM".equalsIgnoreCase(type)) {
                plans.add(new PremiumPlan(name, startDate));
            }
        }
        scanner.close();

        processPlans(plans);
    }
}
