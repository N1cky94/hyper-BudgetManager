package budget.views.sub;

import budget.bookkeeping.FinancialManager;
import budget.util.Keyboard;

public class AnalyzeMenu {
    private final FinancialManager manager;

    public AnalyzeMenu(FinancialManager manager) {
        this.manager = manager;
    }

    public void show() {
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println();
            System.out.println("How do you want to sort?");
            System.out.println("1) Sort all purchases");
            System.out.println("2) Sort by type");
            System.out.println("3) Sort certain type");
            System.out.println("4) Back");
            int choice = Keyboard.requestNextInt();

            switch (choice) {
                case 1 -> sortAllSubMenu();
                case 2 -> sortByTypeSubMenu();
                case 3 -> sortByCertainTypeSubMenu();
                case 4 -> keepGoing = false;
            }

        }
    }

    private void sortAllSubMenu() {

    }

    private void sortByTypeSubMenu() {

    }

    private void sortByCertainTypeSubMenu() {

    }
}
