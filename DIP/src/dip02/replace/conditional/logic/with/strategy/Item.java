package dip02.replace.conditional.logic.with.strategy;

public class Item {
    private final int quantity;
    private final double price;

    public Item(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public double getSubTotal() {
        return quantity * price;
    }
}
