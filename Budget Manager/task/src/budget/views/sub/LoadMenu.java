package budget.views.sub;

import budget.bookkeeping.FinancialManager;

public class LoadMenu {
    private final FinancialManager manager;

    public LoadMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        manager.load();

        System.out.println("\nPurchases were loaded!\n");
    }
}
