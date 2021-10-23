package strings.tricks;

import org.junit.Assert;

//https://www.interviewbit.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Assert.assertEquals("A", longestPalindrome("ABC"));
        System.out.println("Success");

        Assert.assertEquals("aaabaaa", longestPalindrome("aaaabaaa"));
        System.out.println("Success");

        Assert.assertEquals("CEC", longestPalindrome("BBCECAABB"));
        System.out.println("Success");

        Assert.assertEquals("ABA", longestPalindrome("ABA"));
        System.out.println("Success");

    }

    public static String longestPalindrome(String A) {
        String result = A.substring(0, 1);
        for (int start = 0; start < A.length(); start++) {
            for (int end = A.length(); end > start; end--) {
                if (result.length() < end - start) {
                    String test = A.substring(start, end);
                    if (isPalindrome(test)) {
                        result = test;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String input) {
        boolean result = true;
        for (int i = 0, j = input.length() - 1; i <= j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                result = false;
                break;
            }
        }
        return result;
    }


}
