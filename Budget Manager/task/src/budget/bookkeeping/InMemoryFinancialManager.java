package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;
import budget.bookkeeping.transaction.TransactionList;
import budget.bookkeeping.transaction.TransactionType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class InMemoryFinancialManager implements FinancialManager {
    private static final InMemoryFinancialManager MANAGER = new InMemoryFinancialManager(new TransactionList());
    private final FinancialPersistenceService persistence;
    private final TransactionList transactions;

    // todo: Remove methods that can be abused.

    private InMemoryFinancialManager(TransactionList transactions) {
        this.transactions = transactions;
        // todo: Give this object to it for easier saving
        this.persistence = new FinancialFilePersistenceService();
    }

    public static InMemoryFinancialManager getInstance() {
        return MANAGER;
    }

    @Override
    @Deprecated
    public List<Transaction> allTransactions() {
        return transactions.fetchAllTransactions();
    }

    @Override
    public void save() {
        persistence.save(this);
    }

    @Override
    public void load() {
        persistence.load(this);
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
    public List<Transaction> getPurchasesBy(TransactionCategory category) {
        return transactions.fetchTransactionByCategory(category);
    }

    @Override
    public void registerPurchase(String name, double price, TransactionCategory category) {
        Transaction purchase = new Transaction(price, name, TransactionType.OUTGOING, category);
        transactions.registerTransaction(purchase);
    }

    @Override
    public double getCost() {
        return transactions.calculateByType(TransactionType.OUTGOING);
    }

    @Override
    public double getIncome() {
        return transactions.calculateByType(TransactionType.INCOMING);
    }

    @Deprecated
    @Override
    public void deleteAllTransactions() {
        transactions.removeAll(transactions);
    }

    @Deprecated
    @Override
    public void reloadTransactionsFrom(List<Transaction> transactions) {
        deleteAllTransactions();
        this.transactions.addAll(transactions);
    }
}
