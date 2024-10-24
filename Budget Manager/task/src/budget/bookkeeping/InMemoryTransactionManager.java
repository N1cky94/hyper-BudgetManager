package budget.bookkeeping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryTransactionManager implements TransactionManager {
    private static final InMemoryTransactionManager MANAGER = new InMemoryTransactionManager(new ArrayList<>());
    private final List<Transaction> transactions;

    private InMemoryTransactionManager(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public static InMemoryTransactionManager getInstance() {
        return MANAGER;
    }

    @Override
    public void addIncome(double amount) {
        Transaction income = new Transaction(
                amount,
                "income",
                TransactionType.INCOMING,
                null
        );

        transactions.add(income);
    }

    @Override
    public double getBalance() {
        double in = getIncome();
        double out = getCost();

        return in - out;
    }

    @Override
    public boolean hasPurchases() {
        return !getPurchases().isEmpty();
    }

    @Override
    public List<Transaction> getPurchases() {
        return getTransactions(TransactionType.OUTGOING).toList();
    }

    @Override
    public List<Transaction> getPurchasesBy(TransactionCategory category) {
        return getTransactions(TransactionType.OUTGOING)
                .filter(t -> t.category().equals(category))
                .toList();
    }

    private Stream<Transaction> getTransactions(TransactionType type) {
        return transactions.stream().filter(t -> t.type().equals(type));
    }

    @Override
    public void registerPurchase(String name, double price, TransactionCategory category) {
        Transaction purchase = new Transaction(price, name, TransactionType.OUTGOING, category);
        registerTransaction(purchase);
    }

    private void registerTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public double getCost() {
        return getAmountBy(TransactionType.OUTGOING);
    }

    @Override
    public double getIncome() {
        return getAmountBy(TransactionType.INCOMING);
    }

    public double getAmountBy(TransactionType type) {
        return getTransactions(type)
                .mapToDouble(Transaction::amount)
                .sum();
    }

    @Override
    public void deleteAllTransactions() {
        transactions.removeAll(transactions);
    }

    @Override
    public void reloadTransactionsFrom(List<Transaction> transactions) {
        deleteAllTransactions();
        this.transactions.addAll(transactions);
    }
}
