package budget.views;

import budget.bookkeeping.TransactionManager;
import budget.util.Keyboard;

public final class AddPurchaseMenu {
    private final TransactionManager manager;
    AddPurchaseMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        String purchaseName = Keyboard.requestInput("\nEnter purchase name:");
        double purchasePrice = Keyboard.requestNextDouble("Enter its price:");

        manager.registerPurchase(purchaseName, purchasePrice);

        System.out.println("Purchase was added!\n");
    }
}
