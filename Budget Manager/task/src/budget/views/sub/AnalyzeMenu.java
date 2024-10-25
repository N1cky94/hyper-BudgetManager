package budget.views.sub;

import budget.bookkeeping.FinancialManager;
import budget.bookkeeping.transaction.TransactionCategory;
import budget.util.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeMenu {
    private final FinancialManager manager;

    public AnalyzeMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println();
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");
            int choice = Keyboard.requestNextInt();

            switch (choice) {
                case 1 -> sortAllSubMenu();
                case 2 -> sortByTypeSubMenu();
                case 3 -> sortByCertainTypeSubMenu();
                case 4 -> keepGoing = false;
            }
        }
        System.out.println();
    }

    private void sortAllSubMenu() {
        if (!manager.hasPurchases()) {
            System.out.println();
            System.out.println("The purchase list is empty!");
        } else {
            System.out.println();
            System.out.println("All:");
            var list = manager.getPurchasesSorted();
            list.forEach(System.out::println);
            System.out.printf("Total: $%.2f%n", manager.calculateTotal());
        }
    }

    private void sortByTypeSubMenu() {
        System.out.println("\nTypes:");
        List<CategoryTotalPrice> list = new ArrayList<>();
        for (TransactionCategory category: TransactionCategory.values()) {
            double total = manager.calculateTotalBy(category); // should return 0 if empty else should return the sum, also implement this in other menu's
            list.add(new CategoryTotalPrice(total, category.represent()));
        }
        list.stream().sorted().forEach(el -> System.out.printf("%s - $%.2f%n", el.categoryName, el.amount));
        System.out.printf("Total sum: $%.2f%n", manager.calculateTotal());
    }

    private record CategoryTotalPrice(
            double amount,
            String categoryName
    ) implements Comparable<CategoryTotalPrice> {
        @Override
        public int compareTo(CategoryTotalPrice o) {
            return Double.compare(o.amount(), this.amount());
        }
    }

    private void sortByCertainTypeSubMenu() {
        System.out.println();
        System.out.println("Choose the type of purchase");
        System.out.println("1) Food");
        System.out.println("2) Clothes");
        System.out.println("3) Entertainment");
        System.out.println("4) Other");

        int choice = Keyboard.requestNextInt();

        switch (choice) {
            case 1 -> sortByCertain(TransactionCategory.FOOD);
            case 2 -> sortByCertain(TransactionCategory.CLOTHES);
            case 3 -> sortByCertain(TransactionCategory.ENTERTAINMENT);
            case 4 -> sortByCertain(TransactionCategory.OTHER);
        }
    }

    private void sortByCertain(TransactionCategory category) {
        var list = manager.getPurchasesBySorted(category);
        if (list.isEmpty()) {
            System.out.println();
            System.out.println("The purchase list is empty!");
        } else {
            System.out.println();
            System.out.println(category.represent() + ":");
            list.forEach(System.out::println);
            System.out.printf("Total sum: $%.2f%n", manager.calculateTotalBy(category));
        }

    }

}
