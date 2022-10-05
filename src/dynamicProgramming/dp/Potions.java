package dynamicProgramming.dp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/old/problems/potions/
public class Potions {

    private static void test(int testNo, ArrayList<Integer> input, int expected) {
        Potions tester = new Potions();
        Assert.assertEquals(expected, tester.minSmoke(input));
        System.out.println("Success" + testNo);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        inputs.add(new ArrayList<>(Arrays.asList(1)));
        outputs.add(0);

        inputs.add(new ArrayList<>(Arrays.asList(2, 3)));
        outputs.add(6);

        inputs.add(new ArrayList<>(Arrays.asList(2, 3, 4, 5)));
        outputs.add(71);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    public int minSmoke(ArrayList<Integer> A) {
        return Math.min(minSmoke(A, 0), minSmoke(A, 1));
    }

    // not completed, very hard to find recurrence relationship between subproblems
    private int minSmoke(ArrayList<Integer> A, int offset) {
        if (A.size() <= 1) {
            return 0;
        } else if (A.size() == 2) {
            return A.get(0) * A.get(1);
        }
        ArrayList<Integer> mixedPotions = new ArrayList<>();
        int smoke = 0;
        int i = 0 + offset;
        for (; i < A.size() - 1; i += 2) {
            int mix = (A.get(i) + A.get(i + 1)) % 100;
            mixedPotions.add(mix);
            smoke += A.get(i) * A.get(i + 1);
        }
        if (i < A.size()) {
            mixedPotions.add(A.get(i));
        }
        smoke += Math.min(minSmoke(mixedPotions, 0), minSmoke(mixedPotions, 1));
        return smoke;
    }
}
