package string.problems;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        String string1 = "MOM";


        int length = string1.length();
        int i, m, k, d;

        m = 0;
        k = length - 1;
        d = (m + k ) / 2;

        for (i = m; i <= d; i++) {
            if (string1.charAt(m) == string1.charAt(k)) {
                m++;
                k--;
            } else {
                break;
            }
        }
        if (i == d + 1) {
            System.out.println("String is Palindrome");
        } else {
            System.out.println("String is Not a palindrome");
        }

    }

    public static boolean isPalindrome(String string) {

        int length = string.length();
        int i, m, k, d;

        m = 0;
        k = length - 1;
        d = (m + k ) / 2;

        for (i = m; i <= d; i++) {
            if (string.charAt(m) == string.charAt(k)) {
                m++;
                k--;
            } else {
                break;
            }
        }
        if (i == d + 1) {
            return true;
        } else {
            return false;
        }

    }
}
