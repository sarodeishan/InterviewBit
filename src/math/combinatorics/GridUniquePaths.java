package math.combinatorics;

import org.junit.Assert;

import java.util.ArrayList;


//https://www.interviewbit.com/problems/grid-unique-paths/
public class GridUniquePaths {

    public static void main(String[] args) {
        Assert.assertEquals(2, uniquePaths(2, 2));
        System.out.println("Success");

        Assert.assertEquals(1, uniquePaths(100,1));
        System.out.println("Success");
    }

    public static int uniquePaths(int A, int B) {
        int rS = B - 1;
        int dS = A - 1;
        long n = 1;
        int l =  Math.max(rS, dS);
        for (int i = (rS + dS); i > l; i--) {
            n *= i;
        }

        long d = Math.max(1, Math.min(rS, dS));
        for (int i = (int)d - 1; i > 1; i--) {
            d *= i;
        }

        return (int)(n / d);
    }

}
