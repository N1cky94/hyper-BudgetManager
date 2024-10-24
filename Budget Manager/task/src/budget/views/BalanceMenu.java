package budget.views;

import budget.bookkeeping.TransactionManager;

public final class BalanceMenu {
    private final TransactionManager manager;
    BalanceMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        System.out.printf(
                "\nBalance: $%.2f\n\n",
                manager.getBalance()
        );
    }
}
