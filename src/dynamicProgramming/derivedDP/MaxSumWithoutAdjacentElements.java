package dynamicProgramming.derivedDP;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MaxSumWithoutAdjacentElements {

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        MaxSumWithoutAdjacentElements tester = new MaxSumWithoutAdjacentElements();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.adjacent(input));
        long endTime = System.nanoTime();
        output.append("Recursive Memo Solution time: ").append(endTime - startTime).append(" ");

        startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.adjacentDp(input));
        endTime = System.nanoTime();
        output.append("DP Solution time: ").append(endTime - startTime);

        System.out.print("Success" + testNo);
        System.out.println(" " + output);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>(2);
        input1.add(new ArrayList<>(Arrays.asList(1)));
        input1.add(new ArrayList<>(Arrays.asList(2)));
        inputs.add(input1);
        outputs.add(2);

        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>(2);
        input2.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));
        input2.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        inputs.add(input2);
        outputs.add(8);

        ArrayList<ArrayList<Integer>> input3 = new ArrayList<>(2);
        input3.add(new ArrayList<>(Arrays.asList(74, 37, 82, 1)));
        input3.add(new ArrayList<>(Arrays.asList(66, 38, 16, 1)));
        inputs.add(input3);
        outputs.add(156);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        memo.clear();
        return adjacent(A, 0);
    }

    private int adjacent(ArrayList<ArrayList<Integer>> A, int startIndex) {
        if (startIndex >= A.get(0).size()) {
            return 0;
        } else if (memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        } else {
            int sum = 0;
            for (int i = startIndex; i < A.get(0).size() && i < startIndex + 2; i++) {
                int maxNum = Math.max(A.get(0).get(i), A.get(1).get(i));
                int maxSum = 0;
                for (int j = i + 2; j < A.get(0).size(); j++) {
                    maxSum = Math.max(maxSum, adjacent(A, j));
                }
                sum = Math.max(sum, maxNum + maxSum);
            }
            memo.put(startIndex, sum);
            return sum;
        }
    }

    //DP solution
    public int adjacentDp(ArrayList<ArrayList<Integer>> A) {
        int size = A.get(0).size();
        int[] maxSum = new int[size];
        maxSum[0] = Math.max(A.get(0).get(0), A.get(1).get(0));
        if (size == 1) {
            return maxSum[0];
        }
        maxSum[1] = Math.max(maxSum[0], Math.max(A.get(0).get(1), A.get(1).get(1)));

        for (int i = 2; i < size; i++) {
            maxSum[i] = Math.max(maxSum[i - 1], maxSum[i - 2] + Math.max(A.get(0).get(i), A.get(1).get(i)));
        }
        return maxSum[size - 1];
    }

}


