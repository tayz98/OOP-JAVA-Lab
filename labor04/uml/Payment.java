package labor04.uml;

public class Payment {
    private int paymentId;

    public Payment(int paymentId, float amount, Order order) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.order = order;
    }

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

    private float amount;
    private Order order;
}
