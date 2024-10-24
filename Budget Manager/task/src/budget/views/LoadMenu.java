package budget.views;

import budget.bookkeeping.FinancialFilePersistenceService;
import budget.bookkeeping.FinancialManager;
import budget.bookkeeping.FinancialPersistenceService;

public class LoadMenu {
    private final FinancialManager manager;
    private final FinancialPersistenceService persistence;

    LoadMenu(FinancialManager manager) {
        this.manager = manager;
        this.persistence = new FinancialFilePersistenceService();
    }

    public void show() {
        persistence.load(manager);

        System.out.println("\nPurchases were loaded!\n");
    }
}
