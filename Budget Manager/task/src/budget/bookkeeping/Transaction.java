package budget.bookkeeping;

public record Transaction(
        double amount,
        String name,
        TransactionType type,
        TransactionCategory category
) {
    @Override
    public String toString() {
        return "%s $%.2f".formatted(name, amount);
    }
}
