import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static ArrayList<Product> listProduct = new ArrayList<Product>();

    public static void main(String[] args) {
        Product p1= new Product("Iphone", 1000, "Phone", 20);
        Product p2= new Product("Iphone", 1000, "Phone", 10);
        Product p3= new Product("Samsung", 500, "Phone", 10);
        Product p4= new Product("Dell", 3000, "Laptop", 10);
        Product p5= new Product("Asus", 4000, "Laptop", 10);
        listProduct.addAll(Arrays.asList(p1,p2,p3,p4,p5));
        ProductManager productManager = new ProductManager();
        productManager.addProduct(p1);
        productManager.addProduct(p2);
        productManager.addProduct(p3);
        productManager.addProduct(p4);
        productManager.addProduct(p5);
        // productManager.removeProduct("Samsung",5);
        productManager.displayProducts();
        System.out.println();

        //Bai 2
        // productManager.findMostExpensiveProduct();

        //Bai 3
        //productManager.filterCategory("phone");

        //Bai 4
//        productManager.sortByPriceAscending();
//        productManager.sortByPriceDescending();

        //Bai 5
//        Cart cart = new Cart();
//        cart.addProductToCart(p1);
//        cart.addProductToCart(p2);
//        cart.addProductToCart(p3);
//        cart.addProductToCart(p4);
//        cart.removeProductFromCart(p4);
//        System.out.println(cart.getFirstProduct().toString());
//        System.out.println(cart.getLastProduct().toString());

        //Bai 6 -> Hàm addProduct đã loại bỏ trường hợp sản phẩm trùng nhau
        //Bai 7
        User user1=new User("leminhthienanh","anhlmt26122000@gmail.com","123456");
        User user2=new User("testuser","testuser@gmail.com","123456");
        UserManager userManager=new UserManager();
//        userManager.addUser(user1);
//        userManager.checkEmailExist("anhlmt26122000@gmail.com");

        //Bai 8
//        productManager.getAllCategories();

        //Bai 9
//        OrderManager orderManager = new OrderManager();
//        Order order1 = new Order(user1,new ArrayList<>(List.of(p1,p3)));
//        Order order2 = new Order(user2,new ArrayList<>(List.of(p4,p5)));
//        order1.updateStatus("Completed");
//        orderManager.addCompletedOrder(List.of(order1,order2));
//        orderManager.displayCompletedOrders();

        //Bai 10
//        user1.addFavoriteProduct(p1);
//        if(user1.isFavorite(p1)){
//            System.out.println("The product "+p1.getName()+" is favorite of user "+user1.getUsername());
//        }

        //Bai 12
//        userManager.purchase(user1.getUsername());
//        userManager.purchase(user1.getUsername());
//        userManager.purchase(user1.getUsername());
//        userManager.purchase(user2.getUsername());
//        userManager.purchase(user2.getUsername());
//        userManager.displayPurchaseHistory();
//
        //Bai 14
//        ReviewManager reviewManager=new ReviewManager();
//        Review review1=new Review(user1,p1,5,"Very Good");
//        reviewManager.addReview(review1);
//        reviewManager.displayAllReviews();

        //Bai 15
        for (Product p : listProduct) {
            productManager.addProductTree(p);
        }
        productManager.displayProductTree();

        List<Product> filteredProducts = productManager.getProductsInRange(1000, 3500);
        System.out.println("List products in range 1000-3500$");
        for (Product p : filteredProducts) {
            System.out.println(p);
        }
    }
}
