package budget.views.sub;

import budget.bookkeeping.FinancialManager;
import budget.util.Keyboard;

public final class AddIncomeMenu {
    private final FinancialManager manager;
    public AddIncomeMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        int income = Keyboard.requestNextInt("\nEnter income:");
        manager.addIncome(income);
        System.out.println("Income was added!\n");
    }
}
