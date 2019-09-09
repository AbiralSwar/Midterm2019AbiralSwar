package string.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrahman on 04/22/17.
 */
public class DuplicateWord {

    public static void main(String[] args) {
        /*
         * Write a java program to find the duplicate words and their number of occurrences in the string.
         * Also Find the average length of the words.
         */

        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        Set<String> dup = duplicateWords(st);
        System.out.println(" " + st);
        System.out.println(" " + dup);
    }

    public static Set<String> duplicateWords(String input) {

        if (input == null || input.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> dup1 = new HashSet<>();

        String[] words = input.split(" ");
        double length = (double) input.length() / words.length;
        System.out.println("Avg length: " + length);

        Set<String> set1= new HashSet<>();

        ArrayList<String> arraylist = new ArrayList<String>();

        for (String word : words) {
            arraylist.add(word);
            if (!set1.add(word)) {

                dup1.add(word);

            }
        }

        for (String count : arraylist) {
            if (Collections.frequency(arraylist, count) > 1) {
                System.out.println("Number of occurrences: " + count + " in the string: " + Collections.frequency(arraylist, count));
            }

        }
        return dup1;
    }

}
