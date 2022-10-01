package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/min-sum-path-in-triangle/
public class MinSumPathInTriangle {

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        MinSumPathInTriangle tester = new MinSumPathInTriangle();
        Assert.assertEquals(expected, tester.minimumTotal(input));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        input1.add(new ArrayList<>(Arrays.asList(2)));
        input1.add(new ArrayList<>(Arrays.asList(3, 4)));
        input1.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        input1.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        inputs.add(input1);
        outputs.add(11);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }


    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.isEmpty()) {
            return 0;
        } else if (a.size() == 1) {
            return a.get(0).get(0);
        }
        for (int i = 1; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if (j == 0) {
                    right = a.get(i - 1).get(j);
                } else if (j == a.get(i).size() - 1) {
                    left = a.get(i - 1).get(j - 1);
                } else {
                    right = a.get(i - 1).get(j);
                    left = a.get(i - 1).get(j - 1);
                }
                a.get(i).set(j, a.get(i).get(j) + Math.min(left, right));
            }
        }
        return Collections.min(a.get(a.size() - 1));
    }

}
