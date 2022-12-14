package dynamicProgramming.matrixDp;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/old/problems/egg-drop-problem/
public class EggDropProblem {

    private static void test(int testNo, int eggs, int floors, int expected) {
        EggDropProblem tester = new EggDropProblem();
        StringBuilder output = new StringBuilder();
        long startTime = System.nanoTime();
        Assert.assertEquals(expected, tester.solve(eggs, floors));
        long endTime = System.nanoTime();
        output.append("My Solution time: ").append(endTime - startTime).append(" ").append("Success").append(testNo);
        System.out.println(output);
    }

    public static void main(String[] args) {
        ArrayList<Integer> eggList = new ArrayList<>();
        ArrayList<Integer> floorList = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        eggList.add(1);
        floorList.add(2);
        outputs.add(2);

        eggList.add(2);
        floorList.add(10);
        outputs.add(4);

        for (int i = 0; i < eggList.size(); i++) {
            test(i + 1, eggList.get(i), floorList.get(i), outputs.get(i));
        }
    }

    public int solve(int A, int B) {
        return 0;



    }

}
