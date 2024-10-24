package budget;

import budget.bookkeeping.Purchase;
import budget.util.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class BookyApp {
    public static void main(String[] args) {
        List<Purchase> list = new ArrayList<>();

        while(Keyboard.hasNextLine()) {
            String unparsedArticle = Keyboard.requestNextProvidedLine();
            list.add(Purchase.of(unparsedArticle));
        }

        list.forEach(System.out::println);

        double sum = list.stream()
                .mapToDouble(Purchase::price)
                .sum();
        System.out.printf("%nTotal: $%.2f%n", sum);
    }
}
