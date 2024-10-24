package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;
import budget.bookkeeping.transaction.TransactionType;

import java.io.*;
import java.util.List;

public class FinancialFilePersistenceService implements FinancialPersistenceService {

    @Override
    public void save(FinancialManager manager) {
        try (
                FileWriter file = new FileWriter("purchases.txt");
                BufferedWriter writer = new BufferedWriter(file)
        ) {

            List<Transaction> transactions = manager.allTransactions();

            transactions.stream()
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

    @Override
    public void load(FinancialManager manager) {
        try (
                FileReader file = new FileReader("purchases.txt");
                BufferedReader reader = new BufferedReader(file)
                ) {

            var loadedTransactions = reader.lines()
                    .map(this::demarshallTransaction)
                    .toList();

            manager.reloadTransactionsFrom(loadedTransactions);

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
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
