package budget.views;

import budget.bookkeeping.FinancialFilePersistenceService;
import budget.bookkeeping.FinancialManager;
import budget.bookkeeping.FinancialPersistenceService;

public class SaveMenu {
    private final FinancialManager manager;
    private final FinancialPersistenceService persistence;

    SaveMenu(FinancialManager manager) {
        this.manager = manager;
        this.persistence = new FinancialFilePersistenceService();
    }

    public void show() {
        persistence.save(manager);

        System.out.println("\nPurchases were saved!\n");
    }
}
