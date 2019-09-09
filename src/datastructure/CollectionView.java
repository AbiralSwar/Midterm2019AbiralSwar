package datastructure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class CollectionView {

public static void main(String[] args) {
        /*
         Map is created and inserted some data.Retrieve the Collection view of values present in map
         */
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Kathmandu");
        map.put(2, "Lalitpur");
        map.put(3, "Bhaktapur");
        map.put(4, "Pokhara");
        map.put(5, "Ramechap");


        Set<Integer> keys = map.keySet();
        for (Integer key:keys){
                System.out.println(key + " "+"Represent: "+map.get(key));
        }

    }

}
