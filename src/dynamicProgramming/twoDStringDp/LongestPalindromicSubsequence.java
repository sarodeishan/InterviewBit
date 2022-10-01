package dynamicProgramming.twoDStringDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        ArrayList<String> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        String input1 = "bebeeed";
        inputs.add(input1);
        outputs.add(4);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    private static void test(int testNo, String input, int expected) {
        LongestPalindromicSubsequence tester = new LongestPalindromicSubsequence();
        Assert.assertEquals(expected, tester.solve(input));
        System.out.println("Success" + testNo);
    }

    //brute force
    public int solve(String A) {
        char[] x = A.toCharArray();
        char[] y = new StringBuilder(A).reverse().toString().toCharArray();
        int dp[][] = new int[A.length() + 1][A.length() + 1];
        //empty character no match
        for (int i = 0; i <= x.length; i++) {
            for (int j = 0; j <= y.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x.length][y.length];
    }

}
