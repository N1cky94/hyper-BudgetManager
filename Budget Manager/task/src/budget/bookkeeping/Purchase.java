package budget.bookkeeping;

public record Purchase(
        String article,
        double price
) {
    public static Purchase of(String unparsedTicketArticle) {
        String[] splitItem = unparsedTicketArticle.split("[$]");
        return new Purchase(
                splitItem[0].trim(),
                Double.parseDouble(splitItem[1].trim())
        );
    }

    public String toString() {
        return String.format("%s $%.2f", article, price);
    }
}
