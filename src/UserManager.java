import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UserManager{
    private HashSet<User> users=new HashSet<>();
    private HashMap<String, Integer> purchaseHistory=new HashMap<>();

    public void addUser(User u){
        if(!users.contains(u)){
            users.add(u);
            System.out.println("User "+u.getUsername()+" added successfully");
        }else
            System.out.println("User already exists");
    }

    public void checkEmailExist(String email){
        for(User u:users){
            if(u.getEmail().equals(email)){
                System.out.println("Email already exists");
                return;
            }
            else System.out.println("Email does not exist");
        }
    }

    public void purchase(String username){
        purchaseHistory.put(username,purchaseHistory.getOrDefault(username,0)+1);
    }

    public int getPurchase(String username){
        return purchaseHistory.getOrDefault(username,0);
    }

    public void displayPurchaseHistory(){
        if(purchaseHistory.isEmpty()){
            System.out.println("No purchases found");
        }
        else{
            System.out.println("Purchase history:");
            for (Map.Entry<String, Integer> entry : purchaseHistory.entrySet()){
                System.out.println(entry.getKey()+": "+entry.getValue());
            }
        }
    }
}