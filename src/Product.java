public class Product {
    private String name;
    private double price;
    private String category;
    private int stock;

    public Product(String name, double price, String category, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int quantity) {
        //Set lại số lượng mới
        this.stock += quantity;
    }

    public boolean removeQuantity(int amount) {
        if (amount > stock) {
            return false; // Không đủ hàng để xóa
        }
        this.stock -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-20s $%-20.2f %-15s %-10d", name, price, category, stock);
    }
}