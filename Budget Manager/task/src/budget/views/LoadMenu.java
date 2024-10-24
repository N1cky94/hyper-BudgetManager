package budget.views;

import budget.bookkeeping.TransactionManager;

public class LoadMenu {
    private final TransactionManager manager;

    LoadMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        // todo implement loading logic

        System.out.println("\nPurchases were loaded!\n");
    }
}
