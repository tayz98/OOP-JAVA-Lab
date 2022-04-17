package labor04.uml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date createDate;
    private Customer customer;
    private List<Payment> paymentList = new ArrayList<>();
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    // constructor with paymentList and orderDetailList
    public Order(Date createDate, Customer customer, List<Payment> paymentList, List<OrderDetail> orderDetailList) {
        this.createDate = createDate;
        this.customer = customer;
        if (paymentList != null) {
            this.paymentList = paymentList;
        }
        if (orderDetailList != null) {
            this.orderDetailList = orderDetailList;
        }
    }

    // constructor without paymentList and orderDetailList
    public Order(Date createDate, Customer customer) {
        this.createDate = createDate;
        this.customer = customer;
    }

    // getter and setter
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    // method to add a payment to an existing paymentlist
    public void addToPaymentList(Payment payment) {
        this.paymentList.add(payment);
    }

    // method to add an orderDetail to an existing orderDetailList
    public void addToOrderDetailList(OrderDetail orderDetail) {
        this.orderDetailList.add(orderDetail);
    }

    // method to calculate sum of all payments tht belong to this order
    public float addUpPayments() {
        float sum = 0;
        for (Payment p : this.paymentList) {
            sum += p.getAmount();
        }
        return sum;
    }

    // method to calculate the total weight of an order
    public double addUpWeight() {
        double totalWeight = 0;
        for (OrderDetail od : this.orderDetailList) {
            totalWeight += od.calculateWeight();
        }
        return totalWeight;
    }

    // method to calculate the total price of an order (including taxes)
    public double addUpPrice() {
        double endPrice = 0;
        for (OrderDetail od : this.orderDetailList) {
            endPrice += od.calculateSubTotal();
        }
        return Math.round(endPrice * 100.0) / 100.0;
    }

    // method to check if the order is completely paid
    public boolean isPaid() {
        return (this.addUpPrice() - this.addUpPayments()) < 0.001;
    }
}
