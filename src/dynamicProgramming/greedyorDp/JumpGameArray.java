package dynamicProgramming.greedyorDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JumpGameArray {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> inputs = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        ArrayList<Integer> input1 = new ArrayList<>(Arrays.asList(2, 3, 1, 1, 4));
        inputs.add(input1);
        outputs.add(1);
        ArrayList<Integer> input2 = new ArrayList<>(Arrays.asList(3, 2, 1, 0, 4));
        inputs.add(input2);
        outputs.add(0);
        for (int i = 0; i < inputs.size(); i++) {
            test(i + 1, inputs.get(i), outputs.get(i));
        }
    }

    private static void test(int testNo, ArrayList<Integer> input, int expected) {
        JumpGameArray tester = new JumpGameArray();
        Assert.assertEquals(expected, tester.canJump(input));
        System.out.println("Success" + testNo);
    }

    //brute force O(n2) just jump to the index starting from 0th index and check if you can reach last index
    public int canJump(ArrayList<Integer> A) {
        if (A.size() == 0 || A.size() == 1) {
            return A.size();
        }
        boolean[] canReach = new boolean[A.size()];
        canReach[0] = true;
        for (int i = 0; i < A.size(); i++) {
            if (canReach[canReach.length - 1]) {
                break;
            }
            if (canReach[i]) {
                for (int j = i + 1; j <= i + A.get(i) && j < canReach.length; j++) {
                    canReach[j] = true;
                }
            }
        }
        return canReach[canReach.length - 1] ? 1 : 0;
    }
}
