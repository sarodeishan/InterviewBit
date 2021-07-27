package math.adhoc;

import org.junit.Assert;

//https://www.interviewbit.com/problems/step-by-step/
public class AdhocStepByStep {

    public static void main(String[] args) {
        Assert.assertEquals(2, solve(3));
        System.out.println("Success");
        Assert.assertEquals(3, solve(2));
        System.out.println("Success");
    }

    public static int solve(int A) {
        int target = Math.abs(A);
        if (target == 0) return 0;
        int sum = 0, steps = 0;
        while (sum < target) {
            sum += steps;
            steps++;
        }

        while ((sum - target) % 2 == 1) {
            sum += steps;
            steps++;
        }
        return steps - 1;
    }

}
