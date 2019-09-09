package string.problems;

import java.util.Arrays;

/**
 * Created by mrahman on 04/22/17.
 */
public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        String c = "CAT";
        String a = "ACT";
        String m = "ARMY";
        String y = "MARY";

        System.out.println( isAnagram(c,a));
        System.out.println(isAnagram(m,y));
    }

    public static boolean isAnagram(String ca1, String my2){

        if (ca1.length()!= my2.length()){
            return false;
        }
        ca1 = ca1.toUpperCase();
        my2 = my2.toUpperCase();
        char [] str1c = ca1.toCharArray();
        Arrays.sort(str1c);
        char [] str2c = my2.toCharArray();
        Arrays.sort(str2c);
        return Arrays.equals(str1c, str2c);


    }


}
