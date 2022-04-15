package labor04.uml;

public class OrderDetail {
    private int orderDetailId;
    private int qty;
    Item i1 = new Item(530, 1.2, "Mit diesem cleanen Look bist du immer stylish unterwegs", 100.20);
    private String taxStatus;

    public OrderDetail(int orderDetailId, int qty, String taxStatus) {
        this.orderDetailId = orderDetailId;
        this.qty = qty;
        this.taxStatus = taxStatus;
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

    public double calculateSubTotal(double price) {
        return i1.getPrice() * getQty();
    }


    public double calculateWeight(int qty) {
        return i1.getWeight() * qty;
    }

    public int findItemIdFromOrderDetailId(int orderDetailId) {
        return i1.getItemId();
    }
}
