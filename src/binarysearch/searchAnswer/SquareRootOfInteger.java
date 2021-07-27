package binarysearch.searchAnswer;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/square-root-of-integer/
public class SquareRootOfInteger {


    public static void main(String[] args) {
        Assert.assertEquals(3, sqrt(9));
        System.out.println("Success");
        Assert.assertEquals(3, sqrt(11));
        System.out.println("Success");
        Assert.assertEquals(4, sqrt(24));
        System.out.println("Success");
        Assert.assertEquals(6, sqrt(37));
        System.out.println("Success");
        Assert.assertEquals(30506, sqrt(930675566));
        System.out.println("Success");
    }

    public static int sqrt(int A) {
        if (A == 1 || A == 0) {
            return A;
        }
        long low = 1, high = A / 2;
        long answer = -1;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            long square = mid * mid;
            System.out.println("number:" + mid + "square:" + square);
            if (square == A) {
                answer = mid;
                break;
            } else if (square < A) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) answer;
    }
}
