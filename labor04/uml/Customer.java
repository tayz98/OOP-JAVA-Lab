package labor04.uml;

import java.util.ArrayList;
import java.util.List;


public class Customer {
    private int customerId; // selbst
    private String name;
    private String deliveryAddress;
    private String contact;
    private boolean active;
    private List<Order> orderList = new ArrayList<>();

    Customer c1 = new Customer(12345, "Neumann", "Musterstraße 1", "Max.Mustermann@gmail.com", true, null);


    // constructor
    public Customer(int customerId, String name, String deliveryAddress, String contact, boolean active, List<Order> orderList) {
        this.customerId = customerId;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.contact = contact;
        this.active = active;
        this.orderList = orderList;
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

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    // method to add an order to an existing orderlist
    public void addToOrderlist(Order order) {
        this.orderList.add(order);
    }

    public int getCustomerIdForOrderId(Order order) { // make a connection between order and customer. Ist das überhaupt logisch?
        return getCustomerId();
    }
}
