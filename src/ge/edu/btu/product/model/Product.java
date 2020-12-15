package ge.edu.btu.product.model;

public class Product {
    private long id;
    private String productName;
    private String category;
    private double price;
    private double discountPercent;

    public Product() {
    }

    public Product(long id, String productName, String category, double price, double discountPercent) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.discountPercent = discountPercent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOverallPrice(){
        return getPrice() * (1 - discountPercent / 100);
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "Product {" +
                "Code: " + id +
                ", Name: '" + getName() + '\'' +
                ", Category: '" + getCategory() + '\'' +
                ", Price=" + getPrice()  +
                (getDiscountPercent() != 0 ? ", Final price: " + getOverallPrice() + ", Discount percent: " + getDiscountPercent() :
                        ", No discount") +
                "}";
    }
}
