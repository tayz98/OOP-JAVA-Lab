package labor04.uml;

public class OrderDetail {
    private int orderDetailId;
    private int qty;
    OrderDetail oD1 = new OrderDetail(1337, 123, "ABC");
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

    public double calculateSubTotal(double price, Item item) {
        return item.getPrice() * getQty();
    }


    public double calculateWeight(int qty, Item item) {
        return item.getWeight() * qty;
    }


}
