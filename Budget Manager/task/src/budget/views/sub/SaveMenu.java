package budget.views.sub;

import budget.bookkeeping.FinancialFilePersistenceService;
import budget.bookkeeping.FinancialManager;

public class SaveMenu {
    private final FinancialManager manager;

    public SaveMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        manager.save();

        System.out.println("\nPurchases were saved!\n");
    }
}
