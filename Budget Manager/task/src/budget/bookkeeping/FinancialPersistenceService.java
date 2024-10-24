package budget.bookkeeping;

public interface FinancialPersistenceService {
    void save(FinancialManager manager);
    void load(FinancialManager manager);
}
