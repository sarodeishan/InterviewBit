package strings.tricks;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/minimum-appends-for-palindrome/
public class MinimumAppendsForPalindrome {

    public static void main(String[] args) {
        Assert.assertEquals(2, solve("abede"));
        System.out.println("Success");

        Assert.assertEquals(2, solve("aabb"));
        System.out.println("Success");

        Assert.assertEquals(4, solve("aabbc"));
        System.out.println("Success");

    }

    public static int solve(String A) {
        int start = 0, end = A.length() - 1;
        int nonPalindromeLength = start;
        while (start < A.length() && start < end) {
            if (A.charAt(start) == A.charAt(end)) {
                start++;
                end--;
            } else {
                start++;
                end = A.length() - 1;
                nonPalindromeLength = start;
            }
        }
        return nonPalindromeLength;
    }

}
