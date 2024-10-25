package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;

import java.util.List;

public interface FinancialManager {
    List<Transaction> allTransactions();
    void addIncome(double amount);
    double getBalance();
    List<Transaction> getPurchases();
    List<Transaction> getPurchasesBy(TransactionCategory category);
    boolean hasPurchases();
    void registerPurchase(String name, double price, TransactionCategory category);
    double getCost();
    double getIncome();
    void save();
    void load();

}
