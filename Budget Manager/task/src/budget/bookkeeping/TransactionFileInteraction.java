package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;
import budget.bookkeeping.transaction.TransactionList;
import budget.bookkeeping.transaction.TransactionType;

import java.io.*;
import java.util.List;

public class TransactionFileInteraction {
    private static final String FILE_NAME = "purchases.txt";
    private final TransactionList list;

    public TransactionFileInteraction(TransactionList list) {
        this.list = list;
    }

    public void save() {
        try (
                FileWriter file = new FileWriter(FILE_NAME);
                BufferedWriter writer = new BufferedWriter(file)
        ) {

            list.fetchAllTransactions().stream()
                    .map(this::marshallTransaction)
                    .forEach(t -> {
                        try {
                            writer.write(t);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException | RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Transaction> load() {
        try (
                FileReader file = new FileReader(FILE_NAME);
                BufferedReader reader = new BufferedReader(file)
        ) {

            return reader.lines()
                    .map(this::demarshallTransaction)
                    .toList();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            throw new RuntimeException(ioe.getMessage());
        }
    }

    private String marshallTransaction(Transaction transaction) {
        return "%s;%.5f;%s;%s\n".formatted(
                transaction.name(),
                transaction.amount(),
                transaction.type(),
                transaction.category()
        );
    }

    private Transaction demarshallTransaction(String marshalledTransaction) {
        String[] splitTransaction = marshalledTransaction.split(";");

        double amount = Double.parseDouble(splitTransaction[1].replace(',','.'));
        String name = splitTransaction[0];
        TransactionType type = splitTransaction[2].equals("null") ? null : TransactionType.valueOf(splitTransaction[2]);
        TransactionCategory category = splitTransaction[3].equals("null") ? null : TransactionCategory.valueOf(splitTransaction[3]);

        return new Transaction(
                amount,
                name,
                type,
                category
        );
    }

}
