import java.util.List;
import java.util.UUID;


public class Order{
    private String order_id;
    private User user;
    private List<Product> products;
    private double total_price;
    private String status;

    public Order() {
    }

    public Order(User user, List<Product> products) {
        this.order_id = UUID.randomUUID().toString();
        this.user = user;
        this.products = products;
        this.total_price = getTotal_price();
        this.status = "Processing";
    }

    public String getOrder_id() {

        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal_price() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String newStatus) {
        if (newStatus.equals("Processing") || newStatus.equals("Completed") || newStatus.equals("Cancelled")) {
            this.status = newStatus;
        } else {
            System.out.println("Invalid status");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + getOrder_id() + '\'' +
                ", user=" + user.getUsername() +
                ", products=" + products.toString() +
                ", total_price=" + getTotal_price() +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
