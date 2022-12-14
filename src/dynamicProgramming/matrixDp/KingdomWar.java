package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/old/problems/dice-throw/
public class KingdomWar {

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        KingdomWar tester = new KingdomWar();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.solve(input));
        long endTime = System.nanoTime();
        output.append("My Solution time: ").append(endTime - startTime).append(" ").append("Success").append(testNo);
        System.out.println(output);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        input1.add(new ArrayList<>(Arrays.asList(-5, -4, -1)));
        input1.add(new ArrayList<>(Arrays.asList(-3, 2, 4)));
        input1.add(new ArrayList<>(Arrays.asList(2, 5, 8)));
        inputs.add(input1);
        outputs.add(19);

        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        input2.add(new ArrayList<>(Arrays.asList(-1)));
        inputs.add(input2);
        outputs.add(-1);

        ArrayList<ArrayList<Integer>> input3 = new ArrayList<>();
        input3.add(new ArrayList<>(Arrays.asList(-1, 2)));
        inputs.add(input3);
        outputs.add(1);

        ArrayList<ArrayList<Integer>> input4 = new ArrayList<>();
        input4.add(new ArrayList<>(Arrays.asList(-9, -8, -7)));
        input4.add(new ArrayList<>(Arrays.asList(-6, -5, -4)));
        input4.add(new ArrayList<>(Arrays.asList(-3, -2, -1)));
        inputs.add(input4);
        outputs.add(-1);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    // not completed, not getting desired output
    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.isEmpty()) {
            return 0;
        } else if (A.size() == 1 && A.get(0).size() == 1) {
            return A.get(0).get(0);
        }
        int[][][][] dp = new int[A.size()][A.get(0).size()][A.size()][A.get(0).size()];
        dp[0][0][0][0] = A.get(0).get(0);
        int max = dp[0][0][0][0];

        //populate single column sub-matrices
        for (int col = 0; col < A.get(0).size(); col++) {
            for (int eRow = 1; eRow < A.size(); eRow++) {
                dp[0][col][eRow][col] = A.get(eRow).get(col) + dp[0][col][eRow - 1][col];
                max = Math.max(max, dp[0][col][eRow][col]);
            }
        }
        //populate single row sub-matrices
        for (int row = 0; row < A.size(); row++) {
            for (int eCol = 1; eCol < A.get(row).size(); eCol++) {
                dp[row][0][row][eCol] = A.get(row).get(eCol) + dp[row][0][row][eCol - 1];
                max = Math.max(max, dp[row][0][row][eCol]);
            }
        }

        for (int sRow = 0; sRow < A.size(); sRow++) {
            for (int sCol = 0; sCol < A.get(sRow).size(); sCol++) {
                for (int eRow = 0; eRow < A.size(); eRow++) {
                    for (int eCol = 0; eCol < A.get(eRow).size(); eCol++) {
                        int sum = 0;
                        for (int row = sRow; row <= eRow; row++) {
                            sum += dp[row][sCol][row][eCol];
                        }
                        dp[sRow][sCol][eRow][eCol] = sum;
                        max = Math.max(max, sum);
                    }
                }
            }
        }
        return max;
    }

}
