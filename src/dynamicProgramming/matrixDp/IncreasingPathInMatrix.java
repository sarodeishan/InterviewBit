package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/increasing-path-in-matrix/
public class IncreasingPathInMatrix {

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        IncreasingPathInMatrix tester = new IncreasingPathInMatrix();
        Assert.assertEquals(expected, tester.solve(input));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        input1.add(new ArrayList<>(Arrays.asList(1, 2)));
        input1.add(new ArrayList<>(Arrays.asList(3, 4)));
        inputs.add(input1);
        outputs.add(3);

        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        input2.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        input2.add(new ArrayList<>(Arrays.asList(2, 2, 3, 4)));
        input2.add(new ArrayList<>(Arrays.asList(3, 2, 3, 4)));
        input2.add(new ArrayList<>(Arrays.asList(4, 5, 6, 7)));
        inputs.add(input2);
        outputs.add(7);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }


    public int solve(ArrayList<ArrayList<Integer>> A) {
        if (A == null || A.isEmpty() || A.get(0).isEmpty()) {
            return 0;
        }
        boolean[][] maxPath = new boolean[A.size()][A.get(0).size()];
        maxPath[0][0] = true;
        //first column
        for (int row = 1; row < A.size(); row++) {
            if (A.get(row).get(0) > A.get(row - 1).get(0)) {
                maxPath[row][0] = maxPath[row - 1][0];
            }
        }
        //first row
        for (int col = 1; col < A.get(0).size(); col++) {
            if (A.get(0).get(col) > A.get(0).get(col - 1)) {
                maxPath[0][col] = maxPath[0][col - 1];
            }
        }

        for (int row = 1; row < A.size(); row++) {
            for (int col = 1; col < A.get(row).size(); col++) {
                boolean rowPath = false, colPath = false;
                if (A.get(row).get(col) > A.get(row).get(col - 1)) {
                    colPath = maxPath[row][col - 1];
                }
                if (A.get(row).get(col) > A.get(row - 1).get(col)) {
                    rowPath = maxPath[row - 1][col];
                }
                maxPath[row][col] = rowPath || colPath;
            }
        }
        return maxPath[maxPath.length - 1][maxPath[0].length - 1] ? A.size() + A.get(0).size() - 1 : -1;
    }

}
