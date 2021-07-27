package math.digitop;

import org.junit.Assert;

import java.math.BigDecimal;


//https://www.interviewbit.com/problems/next-smallest-palindrome/
public class NextSmallestPalindrome {

    public static void main(String[] args) {
        Assert.assertEquals("1001", solve("999"));
        System.out.println("Success");
        Assert.assertEquals("23632", solve("23545"));
        System.out.println("Success");
        Assert.assertEquals("10000000001", solve("9999999999"));
        System.out.println("Success");
    }

    public static String solve(String A) {
        BigDecimal number = new BigDecimal(A);
        do {
            number = number.add(BigDecimal.ONE);
        } while (!isPalindrome(number));
        return number.toString();
    }

    public static boolean isPalindrome(BigDecimal A) {
        if (A.equals(BigDecimal.ZERO)) {
            return false;
        }
        String input = A.toPlainString();
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
