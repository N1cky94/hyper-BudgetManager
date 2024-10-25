package budget.bookkeeping.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TransactionList {
    private final List<Transaction> transactions;

    public TransactionList() {
        transactions = new ArrayList<>();
    }

    /* todo
        - [x] Add a transaction
        - [x] fetch all
        - [x] fetch by type
        - [x] fetch by category
        - [x] calculate total
        - [x] calculate total by type
        - [x] calculate total by Category
     */

    public void registerTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> fetchAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public List<Transaction> fetchTransactionByType(TransactionType type) {
        return transactions.stream()
                .filter(trans -> trans.type().equals(type))
                .toList();
    }

    public List<Transaction> fetchTransactionByCategory(TransactionCategory category) {
        return transactions.stream()
                .filter(transaction -> transaction.category().equals(category))
                .toList();
    }

    public double calculateBalance() {
        double in = calculateByType(TransactionType.INCOMING);
        double out = calculateByType(TransactionType.OUTGOING);

        return in - out;

    }

    public double calculateByType(TransactionType type) {
        return fetchTransactionByType(type).stream()
                .mapToDouble(Transaction::amount)
                .sum();
    }

    public double calculateByCategory(TransactionCategory category) {
        return fetchTransactionByCategory(category).stream()
                .mapToDouble(Transaction::amount)
                .sum();
    }

//    private Stream<Transaction> onTransaction() {
//        return transactions.stream();
//    }
//
//    private Stream<Transaction> performTypeFilter(TransactionType type) {
//
//    }
}
