package budget.views;

import budget.bookkeeping.TransactionFilePersistenceManager;
import budget.bookkeeping.TransactionManager;
import budget.bookkeeping.TransactionPersistenceManager;

public class SaveMenu {
    private final TransactionManager manager;
    private final TransactionPersistenceManager persistence;

    SaveMenu(TransactionManager manager) {
        this.manager = manager;
        this.persistence = new TransactionFilePersistenceManager();
    }

    public void show() {
        persistence.save(manager);

        System.out.println("\nPurchases were saved!\n");
    }
}
