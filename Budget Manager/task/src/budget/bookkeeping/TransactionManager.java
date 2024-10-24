package budget.bookkeeping;

import java.util.List;

public interface TransactionManager {
    void addIncome(double amount);
    double getBalance();
    List<Transaction> getPurchases();
    void registerPurchase(String name, double price, TransactionCategory category);
    double getCost();
    double getIncome();
}
