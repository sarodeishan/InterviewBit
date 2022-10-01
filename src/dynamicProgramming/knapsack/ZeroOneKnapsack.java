package dynamicProgramming.knapsack;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/old/problems/increasing-path-in-matrix/
public class ZeroOneKnapsack {

    private static void test(int testNo, ArrayList<Integer> input, ArrayList<Integer> input2, int input3, int expected) {
        ZeroOneKnapsack tester = new ZeroOneKnapsack();
        Assert.assertEquals(expected, tester.solve(input, input2, input3));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<ArrayList<Integer>> inputs2 = new ArrayList<>();
        ArrayList<Integer> inputs3 = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(new ArrayList<>(Arrays.asList(60, 100, 120)));
        inputs2.add(new ArrayList<>(Arrays.asList(10, 20, 30)));
        inputs3.add(50);
        outputs.add(220);

        inputs.add(new ArrayList<>(Arrays.asList(10, 20, 30, 40)));
        inputs2.add(new ArrayList<>(Arrays.asList(12, 13, 15, 19)));
        inputs3.add(10);
        outputs.add(0);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), inputs2.get(i), inputs3.get(i), outputs.get(i));
        }
    }

    private static HashMap<String, Integer> map = new HashMap();

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        map.clear();
        return maxValue(A, B, 0, C, 0);
    }

    private int maxValue(ArrayList<Integer> A, ArrayList<Integer> B, int value, int capacity, int index) {
        int maxValue = value;
        String key = capacity + "_" + index;
        if (index >= A.size()) {
            return maxValue;
        } else if (map.containsKey(key)) {
            return map.get(key);
        } else if (capacity >= B.get(index)) {
            maxValue = Math.max(maxValue, maxValue(A, B, value + A.get(index), capacity - B.get(index), index + 1));
            maxValue = Math.max(maxValue, maxValue(A, B, value, capacity, index + 1));
        }
        map.put(key, maxValue);
        return maxValue;
    }

}
