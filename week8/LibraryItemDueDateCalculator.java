package week8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    private String title;
    private LocalDate borrowDate;

    public LibraryItem(String title, LocalDate borrowDate) {
        this.title = title;
        this.borrowDate = borrowDate;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public abstract LocalDate calculateDueDate();
}

class BookItem extends LibraryItem {
    public BookItem(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return getBorrowDate().plusDays(14);
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return getBorrowDate().plusDays(7);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, LocalDate borrowDate) {
        super(title, borrowDate);
    }

    @Override
    public LocalDate calculateDueDate() {
        return getBorrowDate().plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) {
            scanner.close();
            return;
        }

        int n = Integer.parseInt(firstLine);
        LocalDate baseDate = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }

            int spaceIdx = line.indexOf(' ');
            if (spaceIdx == -1) continue;

            String type = line.substring(0, spaceIdx).trim();
            String title = line.substring(spaceIdx + 1).trim();
            if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;
            if (type.equalsIgnoreCase("BOOK")) {
                item = new BookItem(title, baseDate);
            } else if (type.equalsIgnoreCase("DVD")) {
                item = new DVDItem(title, baseDate);
            } else {
                item = new MagazineItem(title, baseDate);
            }
            items.add(item);
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %s%n", item.getTitle(), item.calculateDueDate().toString());
        }

        scanner.close();
    }
}
