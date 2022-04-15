package labor04.uml;

import java.util.Date;

public class Item {
    private int itemId;
    Item i1 = new Item(530, 1.2, "Mit diesem cleanen Look bist du immer stylish unterwegs", 100.20);

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


}
