package math.digitop;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/palindrome-integer/
public class PallindromeInteger {

    public static void main(String[] args) {
        Assert.assertEquals(1, isPalindrome(151));
        System.out.println("Success");
        Assert.assertEquals(0, isPalindrome(-1));
        System.out.println("Success");
    }

    public static int isPalindrome(int A) {
        if (A < 0) {
            return 0;
        }
        String input = Integer.valueOf(A).toString();
        for (int i = 0; i < input.length()/2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

}
