package strings.tricks;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/minimum-characters-required-to-make-a-string-palindromic/
public class MinimumCharactersRequiredToMakeStringPalindromic {

    public static void main(String[] args) {
        Assert.assertEquals(2, solve("ABC"));
        System.out.println("Success");

        Assert.assertEquals(2, solve("AACECAAAA"));
        System.out.println("Success");

        Assert.assertEquals(7, solve("BBCECAABB"));
        System.out.println("Success");

        Assert.assertEquals(0, solve("ABA"));
        System.out.println("Success");

    }

    public static int solve(String A) {
        int n = A.length(), i = 0, j = n - 1, k = n;

        while (i <= j) {
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                while (A.charAt(j) != A.charAt(0)) {
                    j--;
                }
                k = j;
                i = 0;
            }
        }

        if (k == n) return 0;
        return n - k - 1;
    }

    /*
    public static int solve(String A) {
        int result = 0;
        for (int i = A.length(); i > 0; i--) {
            if (isPalindrome(A.substring(0, i))) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
*/
    private static boolean isPalindrome(String input) {
        boolean isPalindrome = true;
        int i = 0, j = input.length() - 1;
        for (; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}
