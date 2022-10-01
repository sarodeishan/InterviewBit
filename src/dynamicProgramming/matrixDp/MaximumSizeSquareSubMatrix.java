package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSizeSquareSubMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        input1.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1)));
        input1.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1, 0)));
        input1.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1, 0)));
        input1.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 0)));
        input1.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        input1.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)));
        inputs.add(input1);
        outputs.add(9);
        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        input2.add(new ArrayList<>(Arrays.asList(1, 1)));
        input2.add(new ArrayList<>(Arrays.asList(1, 1)));
        inputs.add(input2);
        outputs.add(4);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        MaximumSizeSquareSubMatrix tester = new MaximumSizeSquareSubMatrix();
        Assert.assertEquals(expected, tester.solve(input));
        System.out.println("Success" + testNo);
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int maxSquare = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 1){
                    maxSquare = Math.max(maxSquare, 1);
                }
                if (A.get(i).get(j) != 0 && i != 0 && j != 0) {
                    A.get(i).set(j, 1 + Math.min(A.get(i - 1).get(j - 1), Math.min(A.get(i).get(j - 1), A.get(i - 1).get(j))));
                    maxSquare = Math.max(maxSquare, A.get(i).get(j));
                }
            }
        }
        return maxSquare * maxSquare;
    }

}
