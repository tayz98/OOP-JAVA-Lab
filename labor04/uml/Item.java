package labor04.uml;
public class Item {
    private String description;
    private double price;
    private double weight;

    // constructor
    public Item(double weight, String description, double price) {
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    // getter and setter
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