package string.problems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DetermineLargestWord {
    public static void main(String[] args) {
        /*
         Implement to Find the length and longest word in the given sentence below.
         Should return "10 biological".
         */
        String s="Human brain is a biological learning machine";
        String wordNLength = findTheLargestWord(s);
        //implement

        System.out.println(wordNLength);

    }



    public static String findTheLargestWord(String wordGiven){
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";
        //implement
        String[] word = wordGiven.split(" ");

        for(int j=0;j<word.length;j++){
            map.put(word[j].length(),word[j]);
        }
        int length = 0;
        String wd = "";
        for(Map.Entry<Integer, String> checkLength : map.entrySet()){
            if(length< checkLength.getKey()) {
                length = checkLength.getKey();
                wd = checkLength.getValue();
            }
        }
        System.out.println("Largest word: "+wd+" length of the word: "+length);
return wd;
    }
}
