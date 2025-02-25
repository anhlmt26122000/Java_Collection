import java.util.*;

public class ProductManager {
    private List<Product> productList;
    private TreeSet<String> categoryList;
    private TreeMap<Double, List<Product>> productMap;


    public ProductManager() {
        this.productList = new ArrayList<Product>();
        this.categoryList=new TreeSet<String>();
        this.productMap=new TreeMap<>();
    }

    public void addProduct(Product product) {
        for(Product p : this.productList) {
            if(p.getName().equals(product.getName())) {
                p.setStock(product.getStock());
                return;
            }
        }
        productList.add(product);
    }


    public void removeProduct(String name,int quantity) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                if (product.removeQuantity(quantity)) {
                    System.out.println("Product " +name+ " has been delete "+  quantity + " product");
                    if (product.getStock() == 0) {
                        productList.remove(product); // Xóa khỏi danh sách nếu số lượng về 0
                    }
                } else {
                    System.out.println("Dont enough product to delete!");
                }
                return;
            }
        }
        System.out.println("No products found " + name);
    }

    public void displayProducts() {
        if(productList.isEmpty()) {
            System.out.println("No products found");
        }else {
            System.out.println("---------------------- | LIST PRODUCT | -----------------------");
            System.out.printf("%-20s %-20s %-15s %-10s %n", "Product Name", "Price", "Categories", "Stock");
            System.out.println("---------------------------------------------------------------");

            for(Product p : productList) {
                System.out.println(p.toString());
            }
        }
    }

    //Bài 2 Collection
    public Product findMostExpensiveProduct(){
        if(productList.isEmpty()){
            System.out.println("List Product is empty");
            return null;
        }
        Product mostExpensiveProduct= productList.get(0);
        for(Product p:productList){
            if(p.getPrice()>mostExpensiveProduct.getPrice()){
                mostExpensiveProduct=p;
            }
        }
        return mostExpensiveProduct;
    }

    //Bai 3 Collection
    public List<Product> filterCategory(String category){
        List<Product> filterList=new ArrayList<>();
        for(Product p:productList){
            if(p.getCategory().equalsIgnoreCase(category)){
                filterList.add(p);
            }
        }
        return filterList;
    }

    //Bai 4 Sort
    public void sortByPriceAscending(){
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice));
        System.out.println("List products after sorting by ascending price");
        displayProducts();
    }

    public void sortByPriceDescending(){
        Collections.sort(productList, Comparator.comparingDouble(Product::getPrice).reversed());
        System.out.println("List products after sorting by descending price");
        displayProducts();
    }

    //Bai 8 List Category
    public void  getAllCategories(){
        for(Product p : productList) {
            categoryList.add(p.getCategory());
        }
        System.out.println("Category List: ");
        for(String category : categoryList) {
            System.out.println("-"+category);
        }
    }

    //Add to Tree Map
    public void addProductTree(Product product) {
        productMap.computeIfAbsent(product.getPrice(), k -> new ArrayList<>()).add(product);
    }

    // Hiển thị tất cả sản phẩm theo thứ tự giá tăng dần
    public void displayProductTree() {
        if (productMap.isEmpty()) {
            System.out.println("Dont enough product to display");
            return;
        }

        System.out.println("📌 List product tree");
        for (Map.Entry<Double, List<Product>> entry : productMap.entrySet()) {
            System.out.println("💰 Price: " + entry.getKey() + "$");
            for (Product product : entry.getValue()) {
                System.out.println("   ➝ " + product);
            }
        }
    }

    // Lấy danh sách sản phẩm trong khoảng giá
    public List<Product> getProductsInRange(double minPrice, double maxPrice) {
        List<Product> productsInRange = new ArrayList<>();
        for (Map.Entry<Double, List<Product>> entry : productMap.subMap(minPrice, true, maxPrice, true).entrySet()) {
            productsInRange.addAll(entry.getValue());
        }
        return productsInRange;
    }


}