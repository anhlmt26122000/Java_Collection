import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class OrderManager {
    private List<Order> orderList;
    private LinkedHashSet<Order> completeOrders;
    public OrderManager() {
        this.orderList =new ArrayList<>();
        this.completeOrders =new LinkedHashSet<>();
    }

    public void addCompletedOrder(List<Order> orderList){
        for(Order order:orderList){
            if(order.getStatus().equalsIgnoreCase("completed")){
                completeOrders.add(order);
            }
        }
    }
    public void displayCompletedOrders(){
        for(Order order:completeOrders){
            System.out.println(order.toString());
        }
    }
}
