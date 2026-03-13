import java.util.*;

public class MultiLevelCache {

    LinkedHashMap<String,String> L1=
            new LinkedHashMap<>(10,0.75f,true){

                protected boolean removeEldestEntry(Map.Entry e){
                    return size()>3;
                }
            };

    HashMap<String,String> L2=new HashMap<>();
    HashMap<String,String> DB=new HashMap<>();

    public MultiLevelCache(){

        DB.put("video1","data1");
        DB.put("video2","data2");
    }

    public String getVideo(String id){

        if(L1.containsKey(id)){
            System.out.println("L1 HIT");
            return L1.get(id);
        }

        if(L2.containsKey(id)){
            System.out.println("L2 HIT");
            String v=L2.get(id);
            L1.put(id,v);
            return v;
        }

        System.out.println("DB HIT");

        String v=DB.get(id);
        L2.put(id,v);
        return v;
    }

    public static void main(String[] args){

        MultiLevelCache m=new MultiLevelCache();

        m.getVideo("video1");
        m.getVideo("video1");
    }
}