package budget.views;

import budget.bookkeeping.InMemoryTransactionManager;
import budget.bookkeeping.TransactionManager;
import budget.util.Keyboard;

import static java.lang.System.exit;

public final class MainMenu {
    private final TransactionManager manager;
    private final AddIncomeMenu addIncomeMenu;
    private final BalanceMenu balanceMenu;
    private final AddPurchaseMenu addPurchaseMenu;
    private final ListOfPurchasesMenu purchasesMenu;

    public MainMenu() {
        manager = InMemoryTransactionManager.getInstance();
        addIncomeMenu = new AddIncomeMenu(manager);
        addPurchaseMenu = new AddPurchaseMenu(manager);
        balanceMenu = new BalanceMenu(manager);
        purchasesMenu = new ListOfPurchasesMenu(manager);
    }

    public void show() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("0) Exit");

        handleUserInput();
    }

    private void handleUserInput() {
        int choice = Keyboard.requestNextInt();

        switch (choice) {
            case 0 -> closeApplication();
            case 1 -> addIncomeMenu.show();
            case 2 -> addPurchaseMenu.show();
            case 3 -> purchasesMenu.show();
            case 4 -> balanceMenu.show();
            default -> throw new IllegalArgumentException("Chosen choice has no connected function");
        }
    }

    private void closeApplication() {
        System.out.println("\nBye!");
        exit(0);
    }
}