package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//https://www.interviewbit.com/old/problems/dice-throw/
public class DiceThrow {

    private static void test(int testNo, int input1, int input2, int input3, int expected) {
        DiceThrow tester = new DiceThrow();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.findDiceSum(input1, input2, input3));
        long endTime = System.nanoTime();
        output.append("My Solution time: ").append(endTime - startTime).append(" ").append("Success").append(testNo);
        System.out.println(output);
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputs1 = new ArrayList<>();
        ArrayList<Integer> inputs2 = new ArrayList<>();
        ArrayList<Integer> inputs3 = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs1.add(2);
        inputs2.add(4);
        inputs3.add(5);
        outputs.add(4);

        inputs1.add(2);
        inputs2.add(4);
        inputs3.add(1);
        outputs.add(0);
        for (int i = 0; i < inputs1.size(); i++) {
            test(i + 1, inputs1.get(i), inputs2.get(i), inputs3.get(i), outputs.get(i));
        }
    }

    private static HashMap<String, Long> memo = new HashMap<>();

    public int findDiceSum(int A, int B, int C) {
        memo.clear();
        return (int) (noOfWays(A, B, C) % 1000000007);
    }

    private long noOfWays(int dices, int maxValue, int target) {
        String key = dices + "_" + target;
        if (dices == 0 || target <= 0 || dices * maxValue < target || target < dices) {
            return 0;
        } else if (dices == 1 && target <= maxValue) {
            return 1;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        } else {
            long ways = 0;
            for (int i = 1; i <= maxValue; i++) {
                if (target - i > 0) {
                    ways += noOfWays(dices - 1, maxValue, target - i);
                }
            }
            ways %= 1000000007;
            memo.put(key, ways);
            return ways;
        }
    }

}
