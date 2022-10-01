package dynamicProgramming.twoDStringDp;

import org.junit.Assert;

import java.util.ArrayList;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        ArrayList<String> input1 = new ArrayList<>();
        ArrayList<String> input2 = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        input1.add("abbcdgf");
        input2.add("bbadcgf");
        outputs.add(5);
        for (int i = 0; i < input1.size(); i++) {
            test(i + 1, input1.get(i), input2.get(i), outputs.get(i));
        }
    }

    private static void test(int testNo, String inputA, String inputB, int expected) {
        LongestCommonSubsequence tester = new LongestCommonSubsequence();
        Assert.assertEquals(expected, tester.solve(inputA, inputB));
        System.out.println("Success" + testNo);
    }

    public int solve(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}


