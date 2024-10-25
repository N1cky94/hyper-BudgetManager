package budget.bookkeeping.transaction;

import budget.bookkeeping.TransactionFileInteraction;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private final List<Transaction> transactions;
    private final TransactionFileInteraction interact;

    public TransactionList() {
        transactions = new ArrayList<>();
        interact = new TransactionFileInteraction(this);
    }

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
                .filter(transaction -> transaction.type().equals(TransactionType.OUTGOING))
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

    private void upload(List<Transaction> newTransactions) {
        transactions.addAll(newTransactions);
    }

    public void load() {
        upload(interact.load());
    }

    public void persist() {
        interact.save();
    }
}
