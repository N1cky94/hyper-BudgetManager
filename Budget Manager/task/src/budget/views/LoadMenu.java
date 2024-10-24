package budget.views;

import budget.bookkeeping.TransactionFilePersistenceManager;
import budget.bookkeeping.TransactionManager;
import budget.bookkeeping.TransactionPersistenceManager;

public class LoadMenu {
    private final TransactionManager manager;
    private final TransactionPersistenceManager persistence;

    LoadMenu(TransactionManager manager) {
        this.manager = manager;
        this.persistence = new TransactionFilePersistenceManager();
    }

    public void show() {
        persistence.load(manager);

        System.out.println("\nPurchases were loaded!\n");
    }
}
