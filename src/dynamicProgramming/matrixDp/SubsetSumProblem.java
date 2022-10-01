package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/subset-sum-problem/
public class SubsetSumProblem {

    private static void test(int testNo, ArrayList<Integer> input, int input2, int expected) {
        SubsetSumProblem tester = new SubsetSumProblem();
        Assert.assertEquals(expected, tester.solve(input, input2));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<Integer> inputs2 = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2)));
        inputs2.add(9);
        outputs.add(1);

        inputs.add(new ArrayList<>(Arrays.asList(3, 34, 4, 12, 5, 2)));
        inputs2.add(30);
        outputs.add(0);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), inputs2.get(i), outputs.get(i));
        }
    }

    public int recurseSolve(ArrayList<Integer> A, int B) {
        return isSubsetRecurse(B, A, 0) ? 1 : 0;
    }

    public boolean isSubsetRecurse(int target, ArrayList<Integer> A, int index) {
        if (target == 0) {
            return true;
        } else if (target < 0) {
            return false;
        } else if (index >= A.size()) {
            return false;
        } else if (A.get(index) > target) {
            return isSubsetRecurse(target, A, index + 1);
        } else {
            return isSubsetRecurse(target - A.get(index), A, index + 1) || isSubsetRecurse(target, A, index + 1);
        }
    }

    public int solve(ArrayList<Integer> A, int B) {
        boolean dp[][] = new boolean[B + 1][A.size() + 1];
        for (int i = 0; i <= A.size(); i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= B; i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= B; i++) {
            for (int j = 1; j <= A.size(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= A.get(j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - A.get(j - 1)][j - 1];
                }
            }
        }
        return dp[B][A.size()] ? 1 : 0;
    }
}
