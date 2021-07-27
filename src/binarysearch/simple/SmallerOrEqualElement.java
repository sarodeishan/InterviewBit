package binarysearch.simple;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/smaller-or-equal-elements/
public class SmallerOrEqualElement {


    public static void main(String[] args) {

        Assert.assertEquals(4, solve(Arrays.asList(1, 3, 4, 4, 6), 4));
        System.out.println("Success");

        Assert.assertEquals(2, solve(Arrays.asList(1, 2, 5, 5), 3));
        System.out.println("Success");

        Assert.assertEquals(8, solve(Arrays.asList(1, 6, 9, 13, 15, 18, 20, 25, 29, 32, 35, 46), 28));
        System.out.println("Success");

        Assert.assertEquals(10, solve(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1 ), 1));
        System.out.println("Success");
    }

    public static int solve(List<Integer> A, int B) {
        int index = Collections.binarySearch(A, B);
        if (index < 0) {
            return Math.abs(index + 1);
        } else {
            int i = index;
            for (; i < A.size(); i++) {
                if (A.get(i) != B){
                    break;
                }
                index = i;
            }
            return index+1;
        }
    }
}
