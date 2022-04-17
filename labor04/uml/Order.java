package labor04.uml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int orderId; // optional parameter for better handling
    private Date createDate;
    private Customer customer;
    private List<Payment> paymentList = new ArrayList<>();
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    // constructor with paymentList and orderDetailList
    public Order(int orderId, Date createDate, Customer customer, List<Payment> paymentList, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.customer = customer;
        this.paymentList = paymentList;
        this.orderDetailList = orderDetailList;
    }

    // constructor without paymentList and orderDetailList
    public Order(int orderId, Date createDate, Customer customer) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.customer = customer;
    }

    // getter and setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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
    // if the list is null, the method creates a new list
    public void addToPaymentList(Payment payment) {
        if (this.paymentList == null) {
            this.paymentList = new ArrayList<>();
            this.paymentList.add(payment);
        } else {
            this.paymentList.add(payment);
        }
    }

    // method to add an orderDetail to an existing orderDetailList
    // if the list is null, the method creates a new list
    public void addToOrderDetailList(OrderDetail orderDetail) {
        if (this.orderDetailList ==  null) {
            this.orderDetailList = new ArrayList<>();
            this.orderDetailList.add(orderDetail);
        } else {
            this.orderDetailList.add(orderDetail);
        }
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

    public  void orderIsPaid() {
        if (customer.gethasPaid()) {
            System.out.println("The order was paid, thank you.");
        } else {
            System.out.println("You have to pay for the order!");
        }
    }
    public int getCustomerIdForThisOrder() { // could be used for identifying a customer belonging to a specific order. but it would go beyond the scope of the task.
        return customer.getCustomerId();
    }
}
