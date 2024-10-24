package budget.bookkeeping;

public interface TransactionPersistenceManager {
    void save(TransactionManager manager);
    void load(TransactionManager manager);
}
