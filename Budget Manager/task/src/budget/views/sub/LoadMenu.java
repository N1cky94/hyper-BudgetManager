package budget.views.sub;

import budget.bookkeeping.FinancialFilePersistenceService;
import budget.bookkeeping.FinancialManager;
import budget.bookkeeping.FinancialPersistenceService;

public class LoadMenu {
    private final FinancialManager manager;
    private final FinancialPersistenceService persistence;

    public LoadMenu(FinancialManager manager) {
        this.manager = manager;
        this.persistence = new FinancialFilePersistenceService();
    }

    public void show() {
        persistence.load(manager);

        System.out.println("\nPurchases were loaded!\n");
    }
}
