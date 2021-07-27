package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

//https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
public class MinStepsInInfiniteGrid {

    public static void main(String[] args) {
//        List<Integer> A = Arrays.asList(0, 1, 2);
//        List<Integer> B = Arrays.asList(0, 1, 2);
        List<Integer> A = Arrays.asList( 4, 8, -7, -5, -13, 9, -7, 8 );
        List<Integer> B = Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8);
        Assert.assertEquals("Failed", 108, coverPoints(A, B));
        System.out.println("Success");
    }

    public static int coverPoints(List<Integer> A, List<Integer> B) {
        int steps = 0;
        for (int i = 1; i < A.size(); i++) {
            steps = steps + Math.max(Math.abs(A.get(i) - A.get(i - 1)), Math.abs( B.get(i) - B.get(i - 1)));
        }
        return steps;
    }

}
