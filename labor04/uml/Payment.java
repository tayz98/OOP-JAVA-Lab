package labor04.uml;

public class Payment {
    private int paymentId; // selbst
    private float amount;
    private Order order;


    public Payment(int paymentId, float amount, Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.order = order;
    }

    // getter and setter
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

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

    public int getPaymentIdForCustomerId(Order order) { // make a connection between Order and Payment
        return getPaymentId();
    }
}
