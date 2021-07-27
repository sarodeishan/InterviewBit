package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

//https://www.interviewbit.com/problems/perfect-peak-of-array/
public class PerfectPeakOfArray {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(5, 1, 4, 3, 6, 8, 10, 7, 9);
        int result = solve( A);
        Assert.assertEquals("Failed", 1, result);
        System.out.println("Success");

        A = Arrays.asList(5, 1, 4, 4);
        result = solve( A);
        Assert.assertEquals("Failed", 0, result);
        System.out.println("Success");

        A = Arrays.asList( 2, 20, 50, 4, 20, 30, 40);
        result = solve( A);
        Assert.assertEquals("Failed", 0, result);
        System.out.println("Success");
    }
/*
    public static int solve(List<Integer> A) {
        int result =0;
        int element = A.get(0);
        for (int i = 1; i < A.size()-1 ; i++) {
            if (element < A.get(i)){
                element = A.get(i);
            } else {
                continue;
            }
            int smallerElementIndexInRight = findSmallerElementIndexInRight(A, i);
            if (smallerElementIndexInRight == -1){
                return 1;
            } else {
                for (int j = i; j < smallerElementIndexInRight; j++) {
                    if (element < A.get(j)){
                        element = A.get(j);
                    }
                }
                i = smallerElementIndexInRight;
            }
        }
        return result;
    }

    public static int findSmallerElementIndexInRight(List<Integer> B, int offsetIndex){
        int element = B.get(offsetIndex);
        for (int i = offsetIndex+1; i < B.size(); i++) {
            if (element >= B.get(i)){
                return i;
            }
        }
        return -1;
    }*/

    public static int solve(List<Integer> A) {
        int[] leftMax = new int[A.size()];
        int[] rightMin = new int[A.size()];
        leftMax[0] = A.get(0);
        rightMin[A.size()-1] = A.get(A.size()-1);
        int result =0;
        for (int i = 1; i < A.size(); i++) {
            leftMax[i] = Math.max(leftMax[i-1], A.get(i));
        }
        for (int i = A.size()-2; i >=0; i--) {
            rightMin[i] = Math.min(rightMin[i+1], A.get(i));
        }
        for (int i = 1; i < A.size()-1; i++) {
            if (leftMax[i-1]<A.get(i) && rightMin[i+1]>A.get(i)){
                result = 1;
                break;
            }
        }
        return result;
    }

}
