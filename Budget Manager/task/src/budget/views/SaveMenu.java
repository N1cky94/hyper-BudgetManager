package budget.views;

import budget.bookkeeping.TransactionManager;

public class SaveMenu {
    private final TransactionManager manager;

    SaveMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {

        // todo implement logic for saving to .txt file

        System.out.println("\npurchases were saved!\n");
    }
}
