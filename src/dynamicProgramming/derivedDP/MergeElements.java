package dynamicProgramming.derivedDP;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/problems/merge-elements/
public class MergeElements {

    private static void test(int testNo, ArrayList<Integer> input, int expected) {
        MergeElements tester = new MergeElements();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.solve(input));
        long endTime = System.nanoTime();
        output.append("Recursive Memo Solution time: ").append(endTime - startTime).append(" ");
/*
        startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.adjacentDp(input));
        endTime = System.nanoTime();
        output.append("DP Solution time: ").append(endTime - startTime);*/

        System.out.print("Success" + testNo);
        System.out.println(" " + output);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(new ArrayList<>(Arrays.asList(1, 3, 7)));
        outputs.add(15);

        inputs.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        outputs.add(19);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    //solution is copy pasted, not solved, finding recurrence seems hard for me
    public int solve(ArrayList<Integer> A) {
        int[][] dp = new int[202][202];
        for (int i = 0; i < 202; i++)              //INITIALIZE DP WITH -1
            for (int j = 0; j < 202; j++)
                dp[i][j] = -1;
        return solve(A, 0, A.size() - 1, dp);
    }

    public int solve(ArrayList<Integer> A, int i, int j, int[][] dp) {
        if (i > j) return 0;                    //BASE CASES
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];    //CHECK IF ALREADY SOLVED
        int min = Integer.MAX_VALUE, sum = 0, temp = min;
        for (int k = i; k <= j; k++) sum = sum + A.get(k);  //CALCULATE SUM
        for (int k = i; k < j; k++) {
            int a = solve(A, i, k, dp);
            int b = solve(A, k + 1, j, dp);
            temp = Math.min(temp, (a + b + sum));  //CALCULATE TEMP ANSWER
            if (temp < min) min = temp;           //UPDATE MIN IF FOUND BETTER ANSWER
        }
        return dp[i][j] = min;
    }

}


