import java.util.*;

class Vehicle{
    String plate;
    long entry;

    Vehicle(String p){
        plate=p;
        entry=System.currentTimeMillis();
    }
}

public class ParkingSystem {

    Vehicle[] table=new Vehicle[10];

    int hash(String plate){
        return Math.abs(plate.hashCode())%table.length;
    }

    void park(String plate){

        int idx=hash(plate);

        while(table[idx]!=null)
            idx=(idx+1)%table.length;

        table[idx]=new Vehicle(plate);
        System.out.println("Parked at "+idx);
    }

    void exit(String plate){

        for(int i=0;i<table.length;i++){
            if(table[i]!=null && table[i].plate.equals(plate)){
                long time=(System.currentTimeMillis()-table[i].entry)/1000;
                table[i]=null;
                System.out.println("Exited. Time:"+time);
                return;
            }
        }
    }

    public static void main(String[] args){

        ParkingSystem p=new ParkingSystem();

        p.park("ABC123");
        p.park("XYZ999");

        p.exit("ABC123");
    }
}