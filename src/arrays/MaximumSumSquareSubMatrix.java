package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.interviewbit.com/old/problems/maximum-sum-square-submatrix/
public class MaximumSumSquareSubMatrix {

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 1, 1, 1, 1));
        A.add(Arrays.asList(2, 2, 2, 2, 2));
        A.add(Arrays.asList(3, 8, 6, 7, 3));
        A.add(Arrays.asList(4, 4, 4, 4, 4));
        A.add(Arrays.asList(5, 5, 5, 5, 5));
        int result = solve(A, 3);
        Assert.assertEquals("Failed", 48, result);
        System.out.println("Success");

        A = new ArrayList<>();
        A.add(Arrays.asList(2, 2));
        A.add(Arrays.asList(2, 2));
        result = solve(A, 2);
        Assert.assertEquals("Failed", 8, result);
        System.out.println("Success");
    }

    public static int solve(List<List<Integer>> A, int B) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= A.size() - B; i++) {
            for (int j = 0; j <= A.get(i).size() - B; j++) {
                int sum = 0;
                for (int row = i; row < i + B; row++) {
                    for (int col = j; col < j + B; col++) {
                        sum += A.get(row).get(col);
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

}
