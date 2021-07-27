package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.interviewbit.com/problems/maximum-absolute-difference/
public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 3, -1);
        int result = maxArr(A);
        Assert.assertEquals("Failed", 5, result);
        System.out.println("Success");

        A = Arrays.asList(0, 1, 2, 3);
        result = maxArr(A);
        Assert.assertEquals("Failed", 6, result);
        System.out.println("Success");

    }

    public static int maxArr(List<Integer> A) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                int sum = function(A, i, j);
                if (sum > result){
                    result = sum;
                }
            }
        }
        return result;
    }

    public static int function(List<Integer> A, int i, int j){
        return Math.abs(A.get(i)-A.get(j)) + Math.abs(i-j);
    }

}
