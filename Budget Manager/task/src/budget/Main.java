package budget;

import budget.util.Keyboard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        while(Keyboard.hasNextLine()) {
            String unparsedString = Keyboard.requestNextProvidedLine();
            list.add(unparsedString);
        }

        list.stream().forEach(System.out::println);
        double sum = list.stream()
                .mapToDouble(s -> Double.parseDouble(s.split("[$]")[1]))
                .sum();
        System.out.printf("%nTotal: $%.2f%n", sum);
    }
}
