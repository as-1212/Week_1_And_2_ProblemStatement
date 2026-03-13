import java.util.*;

public class Autocomplete {

    HashMap<String,Integer> freq=new HashMap<>();

    public void addQuery(String q){
        freq.put(q,freq.getOrDefault(q,0)+1);
    }

    public void search(String prefix){

        freq.entrySet()
                .stream()
                .filter(e->e.getKey().startsWith(prefix))
                .sorted((a,b)->b.getValue()-a.getValue())
                .limit(5)
                .forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
    }

    public static void main(String[] args){

        Autocomplete a=new Autocomplete();

        a.addQuery("java tutorial");
        a.addQuery("javascript");
        a.addQuery("java tutorial");

        a.search("jav");
    }
}