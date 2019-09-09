package string.problems;

/**
 * Created by mrahman on 04/22/17.
 */
public class Permutation {

    public static void main(String[] args) {

        /*
         * Permutation of String "ABC" is "ABC" "BAC" "BCA" "ACB" "CAB" "CBA".
         * Write Java program to compute all Permutation of a String
         *
         */
        permutation("", "ABCD");
    }
    public static void permutation(String st1, String st2){
        int j = st2.length();

        if(j==0){
            System.out.println(st1);
        }else{
            for(int i=0; i < j; i++){
                permutation(st1 + st2.charAt(i), st2.substring(0, i) + st2.substring(i+1,j));
            }
        }
    }


}
