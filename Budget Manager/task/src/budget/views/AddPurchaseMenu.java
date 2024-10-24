package budget.views;

import budget.bookkeeping.TransactionCategory;
import budget.bookkeeping.FinancialManager;
import budget.util.Keyboard;

public final class AddPurchaseMenu {
    private final FinancialManager manager;
    AddPurchaseMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        while (true) {
            int categoryChoice = Keyboard.requestNextInt(showCategoryMenu());

            if (categoryChoice >= TransactionCategory.values().length + 1) {
                System.out.println();
                return;
            }

            String purchaseName = Keyboard.requestInput("\nEnter purchase name:");
            double purchasePrice = Keyboard.requestNextDouble("Enter its price:");

            manager.registerPurchase(purchaseName, purchasePrice, TransactionCategory.values()[categoryChoice - 1]);

            System.out.println("Purchase was added!");
        }
    }

    private String showCategoryMenu() {
        StringBuilder builder = new StringBuilder("\nChoose the type of purchase\n");
        int i = 1;
        for (TransactionCategory cat : TransactionCategory.values()) {
            builder.append("%d) %s\n".formatted(i++, cat.represent()));
        }
        builder.append("%d) Back".formatted(i));
        return builder.toString();
    }
}
