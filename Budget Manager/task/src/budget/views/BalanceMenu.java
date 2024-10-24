package budget.views;

import budget.bookkeeping.FinancialManager;

public final class BalanceMenu {
    private final FinancialManager manager;
    BalanceMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        System.out.printf(
                "\nBalance: $%.2f\n\n",
                manager.getBalance()
        );
    }
}
