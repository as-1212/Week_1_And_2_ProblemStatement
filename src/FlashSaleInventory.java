import java.util.*;

public class FlashSaleInventory {

    HashMap<String,Integer> inventory=new HashMap<>();
    HashMap<String,Queue<Integer>> waiting=new HashMap<>();

    public FlashSaleInventory(){
        inventory.put("IPHONE15",100);
        waiting.put("IPHONE15",new LinkedList<>());
    }

    public synchronized void purchase(String product,int userId){

        int stock=inventory.get(product);

        if(stock>0){
            inventory.put(product,stock-1);
            System.out.println("User "+userId+" purchased. Remaining:"+ (stock-1));
        }
        else{
            waiting.get(product).add(userId);
            System.out.println("User "+userId+" added to waiting list position "
                    +waiting.get(product).size());
        }
    }

    public static void main(String[] args){
        FlashSaleInventory f=new FlashSaleInventory();

        for(int i=1;i<=105;i++)
            f.purchase("IPHONE15",i);
    }
}