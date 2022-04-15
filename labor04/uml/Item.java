package labor04.uml;

public class Item {
    private int itemId;
    private float weight;
    private String description;
    private double price;

    public Item(int itemId, float weight, String description, double price) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceForQuantity(int qty, double price) {

        return 0;
    }

    public double getWeight(int qty, float weight) {

        return 0;
    }

}
