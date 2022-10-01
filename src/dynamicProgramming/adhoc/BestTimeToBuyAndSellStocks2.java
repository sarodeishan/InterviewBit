package dynamicProgramming.adhoc;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStocks2 {

    public static void main(String[] args) {
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> outputs = new ArrayList<>();
        List<Integer> input1 = Arrays.asList(1, 2, 3);
        inputs.add(input1);
        outputs.add(2);
        List<Integer> input2 = Arrays.asList(5, 2, 10);
        inputs.add(input2);
        outputs.add(8);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }

    }

    private static void test(int testNo, List<Integer> input, int expected) {
        BestTimeToBuyAndSellStocks2 tester = new BestTimeToBuyAndSellStocks2();
        Assert.assertEquals(expected, tester.maxProfit(input));
        Assert.assertEquals(expected, tester.maxProfit2(input));
        System.out.println("Success" + testNo);
    }

    //brute force O(n2)
    public int maxProfit(final List<Integer> A) {
        int profit = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int diff = A.get(j) - A.get(i);
                if (diff > profit) {
                    profit = diff;
                }
            }
        }
        return profit;
    }

    //keep adding in uptrend O(n), as long as price increases, dont sell, if price about to decrease, sell and look for another uptrend
    public int maxProfit2(final List<Integer> A) {
        int profit = 0;
        int tempProfit = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) <= A.get(i + 1)) {
                tempProfit += A.get(i + 1) - A.get(i);
            } else {
                profit += tempProfit;
                tempProfit = 0;
            }
        }
        profit += tempProfit;
        return profit;
    }
}
