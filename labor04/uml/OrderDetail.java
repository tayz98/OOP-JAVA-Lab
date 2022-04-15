package labor04.uml;

public class OrderDetail {
    private int orderDetailId;
    private int qty;

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

    private String taxStatus;

    public int calculateSubTotal() {
        return 0;
    }


    public int calculateWeight() {
        return 0;
    }
}
