package budget;

import budget.views.MainMenu;

public class BookyApp {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();

        while(true) {
            menu.show();
        }
    }
}
