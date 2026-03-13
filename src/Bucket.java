import java.util.*;

class Bucket{
    int tokens;
    long lastRefill;

    Bucket(int max){
        tokens=max;
        lastRefill=System.currentTimeMillis();
    }
}

public class RateLimiter {

    HashMap<String,Bucket> clients=new HashMap<>();
    int limit=5;

    public boolean allow(String id){

        clients.putIfAbsent(id,new Bucket(limit));
        Bucket b=clients.get(id);

        if(b.tokens>0){
            b.tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        RateLimiter r=new RateLimiter();

        for(int i=1;i<=7;i++)
            System.out.println(r.allow("client1"));
    }
}