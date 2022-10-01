package dynamicProgramming.twoDStringDp;

import org.junit.Assert;

import java.util.ArrayList;

public class EditDistance {

    public static void main(String[] args) {
        ArrayList<String> input1 = new ArrayList<>();
        ArrayList<String> input2 = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        input1.add("abad");
        input2.add("abac");
        outputs.add(1);
        input1.add("Anshuman");
        input2.add("Antihuman");
        outputs.add(2);
        input1.add("aa");
        input2.add("abbbb");
        outputs.add(4);
        for (int i = 0; i < input1.size(); i++) {
            test(i + 1, input1.get(i), input2.get(i), outputs.get(i));
        }
    }

    private static void test(int testNo, String inputA, String inputB, int expected) {
        EditDistance tester = new EditDistance();
        Assert.assertEquals(expected, tester.minDistance(inputA, inputB));
        System.out.println("Success" + testNo);
    }

    public int minDistance(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[m][n];
    }

}


