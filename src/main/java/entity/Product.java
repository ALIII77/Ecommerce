package entity;

public class Product {
    private long Id;
    private String name;
    private String category;
    private String description;
    private double price;
    private long quantity;

    public Product() {
    }

    public Product(long id, String name, String category, String description, double price, long count) {
        Id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = count;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
