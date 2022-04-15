package labor04.uml;

import java.util.Date;

public class Item {
    private int itemId;
    OrderDetail oD1 = new OrderDetail(1337, 123, "ABC");
    private String description;
    private double price;
    private double weight;

    public Item(int itemId, double weight, String description, double price) {
        this.itemId = itemId;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {      // we use getPrice instead of getPriceForQuantity because it makes more sense here.
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int findOrderIdForItem(int itemId) {  // to make a connection between the classes OrderDetail and Item
        return oD1.getOrderDetailId();
    }

}
