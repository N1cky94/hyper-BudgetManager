package budget.views;

import budget.bookkeeping.InMemoryFinancialManager;
import budget.bookkeeping.FinancialManager;
import budget.util.Keyboard;
import budget.views.sub.*;

import static java.lang.System.exit;

public final class MainMenu {
    private final FinancialManager manager;
    private final AddIncomeMenu addIncomeMenu;
    private final BalanceMenu balanceMenu;
    private final AddPurchaseMenu addPurchaseMenu;
    private final ListOfPurchasesMenu purchasesMenu;
    private final SaveMenu saveMenu;
    private final LoadMenu loadMenu;

    public MainMenu() {
        manager = InMemoryFinancialManager.getInstance();
        addIncomeMenu = new AddIncomeMenu(manager);
        addPurchaseMenu = new AddPurchaseMenu(manager);
        balanceMenu = new BalanceMenu(manager);
        purchasesMenu = new ListOfPurchasesMenu(manager);
        saveMenu = new SaveMenu(manager);
        loadMenu = new LoadMenu(manager);
    }

    public void show() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
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
            case 5 -> saveMenu.show();
            case 6 -> loadMenu.show();
            default -> throw new IllegalArgumentException("Chosen choice has no connected function");
        }
    }

    private void closeApplication() {
        System.out.println("\nBye!");
        exit(0);
    }
}
