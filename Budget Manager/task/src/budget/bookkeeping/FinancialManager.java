package budget.bookkeeping;

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
    void deleteAllTransactions();
    void reloadTransactionsFrom(List<Transaction> transactions);

}
