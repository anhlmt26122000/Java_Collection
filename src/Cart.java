import java.util.*;

public class Cart {
    private LinkedList<Product> productCart=new LinkedList<>();
    private Map<Product,Integer> productQuantityMap=new HashMap<>();
    public Cart() {
    }
//    public void addProductToCart(Product p) {
//        this.productCart.add(p);
//    }
    public void addProduct(Product product, int quantity) {
        for(Product p: productCart){
            if(p.equals(product)){
                if(productQuantityMap.get(product)+quantity>p.getStock()){
                    System.out.println("Số lượng "+product.getName()+" trong kho chỉ còn "+product.getStock()+ ",hay chọn so luong" +
                            " it hon ");
                    return;
                }else{
                    int oldQuantity=productQuantityMap.get(p);
                    productQuantityMap.remove(product);
                    productQuantityMap.put(product, quantity+oldQuantity);
                    productCart.add(product);
                    return;
                }
            }
        }
        productQuantityMap.put(product, quantity);
        productCart.add(product);
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeProduct(Product product) {
        productQuantityMap.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : productQuantityMap.entrySet()) {
            total+= entry.getKey().getPrice()*entry.getValue();
        }
        return total;
    }

    //Hiển thị sản phẩm trong giỏ
    public void showCart() {
        if (productQuantityMap.isEmpty()) {
            System.out.println("Giỏ hàng trống!");
            return;
        }
        System.out.println("Giỏ hàng:");
        for (Map.Entry<Product, Integer> entry : productQuantityMap.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Số lượng: " + entry.getValue() +
                    " - Tổng giá: " + entry.getKey().getPrice()* entry.getValue() + " VND");
        }
        System.out.println("Tổng tiền: " + getTotalPrice() + " VND");
    }


    public void removeProductFromCart(Product p) {
        if(productCart.remove(p)){
            System.out.println("Product "+p.getName()+" has been removed from cart");
        }else System.out.println("Product not exist");
    }
    public Product getFirstProduct() {
        if(productCart.isEmpty()) return null;
        else return productCart.getFirst();
    }
    public Product getLastProduct() {
        if(productCart.isEmpty()) return null;
        else return productCart.getLast();
    }
}
