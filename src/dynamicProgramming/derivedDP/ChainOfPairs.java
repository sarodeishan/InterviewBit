package dynamicProgramming.derivedDP;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ChainOfPairs {

    private static void test(int testNo, ArrayList<ArrayList<Integer>> input, int expected) {
        ChainOfPairs tester = new ChainOfPairs();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.solve(input));
        long endTime = System.nanoTime();
        output.append("My Solution time: ").append(endTime-startTime).append(" ");

        startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.editorialSolve(input));
        endTime = System.nanoTime();
        output.append("Editorial Solution time: ").append(endTime-startTime);
        System.out.print("Success" + testNo);
        System.out.println(" "+output);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        input1.add(new ArrayList<>(Arrays.asList(5, 24)));
        input1.add(new ArrayList<>(Arrays.asList(39, 60)));
        input1.add(new ArrayList<>(Arrays.asList(15, 28)));
        input1.add(new ArrayList<>(Arrays.asList(27, 40)));
        input1.add(new ArrayList<>(Arrays.asList(50, 90)));
        inputs.add(input1);
        outputs.add(3);

        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        input2.add(new ArrayList<>(Arrays.asList(10, 20)));
        input2.add(new ArrayList<>(Arrays.asList(1, 2)));
        inputs.add(input2);
        outputs.add(1);

        ArrayList<ArrayList<Integer>> input3 = new ArrayList<>();
        input3.add(new ArrayList<>(Arrays.asList(10, 20)));
        input3.add(new ArrayList<>(Arrays.asList(1, 2)));
        input3.add(new ArrayList<>(Arrays.asList(3, 4)));
        inputs.add(input3);
        outputs.add(2);

        ArrayList<ArrayList<Integer>> input4 = new ArrayList<>();
        input4.add(new ArrayList<>(Arrays.asList(196, 295)));
        input4.add(new ArrayList<>(Arrays.asList(76, 98)));
        input4.add(new ArrayList<>(Arrays.asList(429, 642)));
        input4.add(new ArrayList<>(Arrays.asList(169, 663)));
        input4.add(new ArrayList<>(Arrays.asList(264, 742)));
        input4.add(new ArrayList<>(Arrays.asList(6, 602)));
        input4.add(new ArrayList<>(Arrays.asList(26, 437)));
        input4.add(new ArrayList<>(Arrays.asList(355, 469)));
        input4.add(new ArrayList<>(Arrays.asList(23, 582)));
        input4.add(new ArrayList<>(Arrays.asList(147, 784)));
        inputs.add(input4);
        outputs.add(2);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    private HashMap<Integer, Integer> memo = new HashMap<>();

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int maxLength = 1;
        for (int i = 0; i < A.size(); i++) {
            maxLength = Math.max(maxLength, recurse(A, i));
        }
        return maxLength;
    }

    private int recurse(ArrayList<ArrayList<Integer>> A, int pairIndex) {
        if (pairIndex >= A.size()) {
            return 0;
        } else {
            if (memo.containsKey(pairIndex)) {
                return memo.get(pairIndex);
            }
            int maxLength = 1;
            for (int i = pairIndex; i < A.size(); i++) {
                if (A.get(pairIndex).get(1) < A.get(i).get(0)) {
                    maxLength = Math.max(maxLength, 1 + recurse(A, i));
                }
            }
            memo.put(pairIndex, maxLength);
            return maxLength;
        }
    }

    public int editorialSolve(ArrayList<ArrayList<Integer>> A) {

        //dp array to store the length of longest subsequence at dp[index] which ends with pair at index
        int dp[] = new int[A.size()];

        //stores the length of largest subsequence
        int max = 1;

        //Initializing the array with 1 because the element itself counts as a seq of length 1
        Arrays.fill(dp, 1);

        //Start with index 1 because sequence ending at 0th pair will have only that pair
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j).get(1) < A.get(i).get(0)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    if (dp[i] > max)
                        max = dp[i];
                }
            }
        }

        //Returns the largest subsequence
        return max;
    }

}


