package budget.bookkeeping.transaction;

public record Transaction(
        double amount,
        String name,
        TransactionType type,
        TransactionCategory category
) implements Comparable<Transaction> {
    @Override
    public String toString() {
        return "%s $%.2f".formatted(name, amount);
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(o.amount(), this.amount());
    }
}
