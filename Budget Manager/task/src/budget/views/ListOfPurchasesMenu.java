package budget.views;

import budget.bookkeeping.Transaction;
import budget.bookkeeping.TransactionManager;

import java.util.List;

public final class ListOfPurchasesMenu {
    private final TransactionManager manager;
    ListOfPurchasesMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        List<Transaction> purchases = manager.getPurchases();
        if (purchases.isEmpty()) {
            System.out.println("\nThe purchase list is empty\n");
        } else {
            System.out.println();
            purchases.forEach(System.out::println);
            System.out.println(manager.getCost());
            System.out.println();
        }
    }
}
