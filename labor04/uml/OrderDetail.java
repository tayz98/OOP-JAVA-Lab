package labor04.uml;

public class OrderDetail {
    private int orderDetailId;
    private int qty;


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

    private String taxStatus;

    public double calculateSubTotal(int qty) {
        return 0;
    }


    public double calculateWeight(int qty, float weight) {
        return 0;
    }
}
