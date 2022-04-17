package labor04.uml;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId; // optional parameter for better handling
    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;
    private boolean hasPaid;
    private List<Order> orderList = new ArrayList<>();

    // constructor with orderList
    public Customer(int customerId, String name, String deliveryAddress, String contact, boolean active, boolean hasPaid, List<Order> orderList) {
        this.customerId = customerId;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.active = active;
        this.hasPaid = hasPaid;
        this.orderList = orderList;
    }

    // constructor without orderList
    public Customer(int customerId, String name, String deliveryAddress, String contact, boolean active, boolean hasPaid) {
        this.customerId = customerId;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.active = active;
    }

    // getter and setter methods
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean gethasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    // method to add an order to an existing orderlist
    public void addToOrderlist(Order order) {
        if (this.orderList == null) { // if you pass "null" to the order list, a new list needs to be generated. Otherwise, the list will contain an empty element before a new element (new order) gets added.
            this.orderList = new ArrayList<>();
            this.orderList.add(order);
        } else {
            this.orderList.add(order);
        }
    }
}