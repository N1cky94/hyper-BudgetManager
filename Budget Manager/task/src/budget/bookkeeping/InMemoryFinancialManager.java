package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;
import budget.bookkeeping.transaction.TransactionList;
import budget.bookkeeping.transaction.TransactionType;

import java.util.List;

public class InMemoryFinancialManager implements FinancialManager {
    private static final InMemoryFinancialManager MANAGER = new InMemoryFinancialManager(new TransactionList());
    private final TransactionList transactions;

    // todo: Remove methods that can be abused.

    private InMemoryFinancialManager(TransactionList transactions) {
        this.transactions = transactions;
    }

    public static InMemoryFinancialManager getInstance() {
        return MANAGER;
    }

    @Override
    public void save() {
        transactions.persist();
    }

    @Override
    public void load() {
        transactions.load();
    }

    @Override
    public void addIncome(double amount) {
        Transaction income = new Transaction(
                amount,
                "income",
                TransactionType.INCOMING,
                null
        );

        transactions.registerTransaction(income);
    }

    @Override
    public double getBalance() {
        return transactions.calculateBalance();
    }

    @Override
    public boolean hasPurchases() {
        return !getPurchases().isEmpty();
    }

    @Override
    public List<Transaction> getPurchases() {
        return transactions.fetchTransactionByType(TransactionType.OUTGOING);
    }

    @Override
    public List<Transaction> getPurchasesSorted() {
        return transactions.fetchTransactionByType(TransactionType.OUTGOING)
                .stream()
                .sorted()
                .toList();
    }

    @Override
    public List<Transaction> getPurchasesBy(TransactionCategory category) {
        return transactions.fetchTransactionByCategory(category);
    }

    @Override
    public List<Transaction> getPurchasesBySorted(TransactionCategory category) {
        return transactions.fetchTransactionByCategory(category)
                .stream()
                .sorted()
                .toList();
    }

    @Override
    public void registerPurchase(String name, double price, TransactionCategory category) {
        Transaction purchase = new Transaction(price, name, TransactionType.OUTGOING, category);
        transactions.registerTransaction(purchase);
    }

    @Override
    public double calculateTotalBy(TransactionCategory category) {
        return transactions.calculateByCategory(category);
    }

    @Override
    public double calculateTotal() {
        return transactions.calculateByType(TransactionType.OUTGOING);
    }
}
