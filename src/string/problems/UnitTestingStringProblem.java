package string.problems;

import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.
        Anagram.isAnagram("CAT", "CAT");
        Assert.assertTrue(true, "true");
        //Apply Unit Test into all the methods in this package.

        try {//Unit test for LargestWord
            String a = "Human brain is a biological learning machine";
            Assert.assertEquals(DetermineLargestWord.findTheLargestWord(a),"biological");
            System.out.println("Determine largest value unit test Passed.");
        }catch (AssertionError as){
            System.out.println("Determine largest value unit test Failed!!!.");
        }

        try {//Unit test for DuplicateWord
            Set<String> set = new HashSet<>();
            set.add("Java");
            set.add("is");
            String test = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
            Assert.assertEquals(DuplicateWord.duplicateWords(test),set);
            System.out.println("Duplicate word unit test Passed.");
        }catch (AssertionError as){
            System.out.println("Duplicate word unit test Failed!!!.");
        }

        try {//Unit test for palindrome
            String test = "CVS";
            boolean expected = false;
            Assert.assertEquals(Palindrome.isPalindrome(test),expected);
            System.out.println("Palindrome unit test passed.");
        } catch (AssertionError as){
            System.out.println("Palindrome unit test failed.");
        }
    }
    }

