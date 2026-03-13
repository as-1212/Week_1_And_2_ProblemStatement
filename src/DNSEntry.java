import java.util.*;

class DNSEntry{
    String ip;
    long expiry;

    DNSEntry(String ip,long ttl){
        this.ip=ip;
        this.expiry=System.currentTimeMillis()+ttl;
    }
}

public class DNSCache {

    HashMap<String,DNSEntry> cache=new HashMap<>();
    int hits=0,miss=0;

    public String resolve(String domain){

        if(cache.containsKey(domain)){
            DNSEntry e=cache.get(domain);

            if(System.currentTimeMillis()<e.expiry){
                hits++;
                return "Cache HIT "+e.ip;
            }
        }

        miss++;
        String ip="192.168."+new Random().nextInt(255)+"."+new Random().nextInt(255);
        cache.put(domain,new DNSEntry(ip,5000));

        return "Cache MISS "+ip;
    }

    public void stats(){
        int total=hits+miss;
        System.out.println("Hit rate:"+(hits*100.0/total)+"%");
    }

    public static void main(String[] args){
        DNSCache d=new DNSCache();

        System.out.println(d.resolve("google.com"));
        System.out.println(d.resolve("google.com"));
        d.stats();
    }
}