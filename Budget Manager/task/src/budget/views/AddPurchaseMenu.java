package budget.views;

import budget.bookkeeping.TransactionCategory;
import budget.bookkeeping.TransactionManager;
import budget.util.Keyboard;

public final class AddPurchaseMenu {
    private final TransactionManager manager;
    AddPurchaseMenu(TransactionManager manager) {
        this.manager = manager;
    }

    public void show() {
        int categoryChoice = Keyboard.requestNextInt(showCategoryMenu());
        String purchaseName = Keyboard.requestInput("\nEnter purchase name:");
        double purchasePrice = Keyboard.requestNextDouble("Enter its price:");

        if (categoryChoice >= TransactionCategory.values().length + 1) {
            return;
        }

        manager.registerPurchase(purchaseName, purchasePrice, TransactionCategory.values()[categoryChoice - 1]);

        System.out.println("Purchase was added!\n");
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
