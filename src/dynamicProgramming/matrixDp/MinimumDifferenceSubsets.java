package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/old/problems/subset-sum-problem/
public class MinimumDifferenceSubsets {

    private static void test(int testNo, ArrayList<Integer> input, int expected) {
        MinimumDifferenceSubsets tester = new MinimumDifferenceSubsets();
        Assert.assertEquals(expected, tester.solve(input));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(new ArrayList<>(Arrays.asList(1, 6, 11, 5)));
        outputs.add(1);

        inputs.add(new ArrayList<>(Arrays.asList(68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22, 17, 19, 96, 48, 27, 72, 39, 70, 13, 68, 100, 36, 95, 4, 12, 23, 34, 74, 65, 42, 12, 54, 69, 48, 45)));
        outputs.add(1);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    public int solve(ArrayList<Integer> A) {
        int total = A.stream().mapToInt(Integer::intValue).sum();
        int target = total / 2;
        boolean dp[][] = new boolean[target + 1][A.size() + 1];
        for (int i = 0; i <= A.size(); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= target; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= A.size(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= A.get(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - A.get(j - 1)][j - 1];
                }
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j]) {
                    return Math.abs(total - 2 * i);
                }
            }
        }
        return A.get(0);
    }
}
