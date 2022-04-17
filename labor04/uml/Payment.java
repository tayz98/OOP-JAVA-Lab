package labor04.uml;

public class Payment {
    private float amount;
    private Order order;

    public Payment(float amount, Order order) {
        this.amount = amount;
        this.order = order;
        order.addToPaymentList(this);
    }
    // getter and setter
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}