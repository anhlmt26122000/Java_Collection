import java.util.HashSet;
import java.util.Set;

public class User{
    private String username;
    private String email;
    private String password;
    private Set<Product> favoriteProducts;
    // private String role;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.favoriteProducts = new HashSet<Product>();
        // this.role = this instanceof Admin ? "ADMIN" : "CUSTOMER";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    public void removeFavoriteProduct(Product product) {
        favoriteProducts.remove(product);
    }
    public boolean isFavorite(Product product) {
        return favoriteProducts.contains(product);
    }

}