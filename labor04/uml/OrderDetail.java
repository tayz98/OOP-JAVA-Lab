package labor04.uml;

public class OrderDetail {
    private int orderDetailId; // optional parameter for better handling
    private int qty;
    private String taxStatus;
    private Order order;
    private Item item;

    // constructor
    public OrderDetail(int orderDetailId, int qty, String taxStatus, Order order, Item item) {
        this.orderDetailId = orderDetailId;
        this.qty = qty;
        this.taxStatus = taxStatus;
        this.order = order;
        this.item = item;
        order.addToOrderDetailList(this);
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    // method to calculate the total price (quantity * price of item)
    public double getPriceForQuantity() {
        return item.getPrice() * this.getQty();
    }

    // method to calculate the total sum (including taxes)
    public double calculateSubTotal() {
        if (this.taxStatus.equals("german")) {
            return Math.round((this.getPriceForQuantity() * 1.19) * 100.0) / 100.0;
        } else {
            return Math.round(this.getPriceForQuantity() * 100.0) / 100.0;
        }
    }
    // method to calculate the total weight of all items (quantity * weight of item)
    public double calculateWeight() {
        return item.getWeight() * this.getQty();
    }
}