package budget.views;

import budget.bookkeeping.Transaction;
import budget.bookkeeping.TransactionCategory;
import budget.bookkeeping.TransactionManager;
import budget.util.Keyboard;

import java.util.List;

public final class ListOfPurchasesMenu {
    private final TransactionManager manager;
    ListOfPurchasesMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {

        if (!manager.hasPurchases()) {
            showNoPurchases();
            return;
        }

        boolean keepGoing = true;

        while(keepGoing) {

            System.out.println("\nChoose the type of purchase");

            System.out.println("1) Food");
            System.out.println("2) Clothes");
            System.out.println("3) Entertainment");
            System.out.println("4) Other");
            System.out.println("5) All");
            System.out.println("6) Back");

            int catChoice = Keyboard.requestNextInt();
            switch (catChoice) {
                case 1, 2, 3, 4 -> getByCategory(TransactionCategory.values()[catChoice - 1]);
                case 5 -> getAll();
                case 6 -> keepGoing = false;
            }
        }
        System.out.println();
    }

    private void showNoPurchases() {
        System.out.println("\nThe purchase list is empty\n");
    }

    private void getAll() {
        List<Transaction> purchases = manager.getPurchases();
        System.out.println("\nAll:");
        processPurchases(purchases);
    }

    private void getByCategory(TransactionCategory category) {
        List<Transaction> purchases = manager.getPurchasesBy(category);
        System.out.println("\n" + category.represent() + ":");
        processPurchases(purchases);
    }

    private void processPurchases(List<Transaction> purchases) {
        if (purchases.isEmpty()) {
            showNoPurchases();
        } else {
            purchases.forEach(System.out::println);
            System.out.println("Total sum: $" + manager.getCost());
        }
    }
}
