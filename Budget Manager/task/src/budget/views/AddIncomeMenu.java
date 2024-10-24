package budget.views;

import budget.bookkeeping.TransactionManager;
import budget.util.Keyboard;

public final class AddIncomeMenu {
    private final TransactionManager manager;
    AddIncomeMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        int income = Keyboard.requestNextInt("\nEnter income:");
        manager.addIncome(income);
        System.out.println("Income was added!\n");
    }
}
