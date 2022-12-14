package dynamicProgramming.simpleArrayDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/merge-elements/
public class TilingWithDominoes {

    private static void test(int testNo, Integer input, int expected) {
        TilingWithDominoes tester = new TilingWithDominoes();
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
        ArrayList<Integer> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(2);
        outputs.add(3);

        inputs.add(1);
        outputs.add(0);

        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    public int solve(int n) {
        if ((n & 1) == 1)
            return 0;
        long[] A = new long[n + 1];
        long[] B = new long[n + 1];
        A[0] = 1;
        A[1] = 0;
        B[0] = 0;
        B[1] = 1;
        for (int i = 2; i <= n; i++) {
            A[i] = (A[i - 2] + (2 * B[i - 1]) % 1000000007) % 1000000007;
            B[i] = (A[i - 1] + B[i - 2]) % 1000000007;
        }

        return (int) (A[n] % 1000000007);
    }

}


