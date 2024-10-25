package budget.bookkeeping;

import budget.bookkeeping.transaction.Transaction;
import budget.bookkeeping.transaction.TransactionCategory;

import java.util.List;

public interface FinancialManager {
    void addIncome(double amount);
    double getBalance();
    List<Transaction> getPurchases();
    List<Transaction> getPurchasesBy(TransactionCategory category);
    boolean hasPurchases();
    void registerPurchase(String name, double price, TransactionCategory category);
    void save();
    void load();

}
