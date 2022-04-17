package labor04.uml;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;
    private List<Order> orderList = new ArrayList<>();

    // constructor with orderList
    public Customer(String name, String deliveryAddress, String contact, boolean active, List<Order> orderList) {
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.active = active;
        if (orderList != null) {
            this.orderList = orderList;
        }
    }

    // constructor without orderList
    public Customer(String name, String deliveryAddress, String contact, boolean active) {
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.active = active;
    }

    // getter and setter methods
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

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    // method to add an order to an existing orderlist
    public void addToOrderlist(Order order) {
        this.orderList.add(order);
    }
}