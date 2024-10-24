package budget.bookkeeping;

public interface TransactionPersistanceManager {
    void save(TransactionManager manager);
    void load(TransactionManager manager);
}
