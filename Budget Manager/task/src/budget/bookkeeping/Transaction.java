package budget.bookkeeping;

public record Transaction(
        double amount,
        String name,
        TransactionType type
) {
    @Override
    public String toString() {
        return "%s $%.2f".formatted(name, amount);
    }
}
