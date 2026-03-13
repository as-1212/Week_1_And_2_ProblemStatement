import java.util.*;

public class PlagiarismDetector {

    HashMap<String,Set<String>> index=new HashMap<>();

    public List<String> getNgrams(String text,int n){
        String[] words=text.split(" ");
        List<String> grams=new ArrayList<>();

        for(int i=0;i<=words.length-n;i++){
            String gram="";
            for(int j=0;j<n;j++)
                gram+=words[i+j]+" ";
            grams.add(gram.trim());
        }
        return grams;
    }

    public void addDocument(String id,String text){

        for(String g:getNgrams(text,3)){
            index.putIfAbsent(g,new HashSet<>());
            index.get(g).add(id);
        }
    }

    public void check(String id,String text){

        int match=0;

        for(String g:getNgrams(text,3)){
            if(index.containsKey(g))
                match++;
        }

        System.out.println("Matches:"+match);
    }

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.addDocument("essay1","data structures and algorithms are important");
        p.check("essay2","data structures and algorithms are useful");
    }
}import java.util.*;

public class PlagiarismDetector {

    HashMap<String,Set<String>> index=new HashMap<>();

    public List<String> getNgrams(String text,int n){
        String[] words=text.split(" ");
        List<String> grams=new ArrayList<>();

        for(int i=0;i<=words.length-n;i++){
            String gram="";
            for(int j=0;j<n;j++)
                gram+=words[i+j]+" ";
            grams.add(gram.trim());
        }
        return grams;
    }

    public void addDocument(String id,String text){

        for(String g:getNgrams(text,3)){
            index.putIfAbsent(g,new HashSet<>());
            index.get(g).add(id);
        }
    }

    public void check(String id,String text){

        int match=0;

        for(String g:getNgrams(text,3)){
            if(index.containsKey(g))
                match++;
        }

        System.out.println("Matches:"+match);
    }

    public static void main(String[] args){

        PlagiarismDetector p=new PlagiarismDetector();

        p.addDocument("essay1","data structures and algorithms are important");
        p.check("essay2","data structures and algorithms are useful");
    }
}