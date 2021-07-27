package arrays;

import org.junit.Assert;

import java.util.*;

//https://www.interviewbit.com/problems/maximum-sum-triplet/
public class MaximumSumOfTriplet {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 5, 3, 1, 4, 9);
        Assert.assertEquals("Failed", 16, solve(A));
        System.out.println("Success");
        A = Arrays.asList(1, 2, 3);
        Assert.assertEquals("Failed", 6, solve(A));
        System.out.println("Success");
    }

    public static int solve(List<Integer> A) {
        int result = 0;
        if (A.size() < 3) {
            return result;
        }
        List<Integer> rightMax = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) {
            rightMax.add(0);
        }
        rightMax.set(A.size() - 1, A.get(A.size() - 1));
        for (int i = A.size() - 2; i >= 0; i--) {
            rightMax.set(i, Math.max(rightMax.get(i + 1), A.get(i)));
        }
        TreeSet<Integer> leftMax = new TreeSet();
        leftMax.add(A.get(0));
        for (int i = 1; i < A.size()-1; i++) {
            int rMax = rightMax.get(i+1);
            Integer lMax = leftMax.lower(A.get(i));
            if(lMax != null && A.get(i) < rMax){
                result = Math.max(result, lMax + A.get(i) + rMax);
            }
            leftMax.add(A.get(i));
        }
        return result;
    }

/*
    public static int solve(List<Integer> A) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            int secondNum = Integer.MIN_VALUE;

            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) < A.get(j) && secondNum < A.get(j)) {
                    int thirdNum = Integer.MIN_VALUE;

                    for (int k = j + 1; k < A.size(); k++) {
                        if (A.get(j) < A.get(k) && thirdNum < A.get(k)) {
                            secondNum = A.get(j);
                            thirdNum = A.get(k);
                            int sum = A.get(i) + A.get(j) + A.get(k);
                            if (sum >= result) {
                                result = sum;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }*/

}
