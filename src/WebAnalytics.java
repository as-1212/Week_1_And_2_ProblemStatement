import java.util.*;

public class WebAnalytics {

    HashMap<String,Integer> pageViews=new HashMap<>();
    HashMap<String,Set<String>> unique=new HashMap<>();
    HashMap<String,Integer> source=new HashMap<>();

    public void process(String url,String user,String src){

        pageViews.put(url,pageViews.getOrDefault(url,0)+1);

        unique.putIfAbsent(url,new HashSet<>());
        unique.get(url).add(user);

        source.put(src,source.getOrDefault(src,0)+1);
    }

    public void dashboard(){

        System.out.println("Top Pages:");

        pageViews.entrySet()
                .stream()
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(5)
                .forEach(e->{
                    System.out.println(e.getKey()+" views:"+e.getValue()
                            +" unique:"+unique.get(e.getKey()).size());
                });

        System.out.println("Traffic Sources:"+source);
    }

    public static void main(String[] args){

        WebAnalytics w=new WebAnalytics();

        w.process("/news","u1","google");
        w.process("/news","u2","facebook");
        w.process("/sports","u1","google");

        w.dashboard();
    }
}