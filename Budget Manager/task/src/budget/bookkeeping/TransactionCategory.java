package budget.bookkeeping;

public enum TransactionCategory {
    FOOD("Food"),
    CLOTHES("Clothes"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other");

    private final String representation;

    TransactionCategory(String representation) {
        this.representation = representation;
    }

    public String represent() {
        return representation;
    }
}
