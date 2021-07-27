package math.numbertheory;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


//https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
public class TrailingZerosInFactorial {

    public static void main(String[] args) {
        Assert.assertEquals(0, trailingZeroes(4));
        System.out.println("Success");
        Assert.assertEquals(1, trailingZeroes(5));
        System.out.println("Success");
        Assert.assertEquals(2, trailingZeroes(10));
        System.out.println("Success");
        Assert.assertEquals(24, trailingZeroes(100));
        System.out.println("Success");
    }

    public static int trailingZeroes(int A) {
//        int quotient = A / 10;
//        if (quotient == 0) {
//            return A / 5;
//        }
//        int trailingZerosDueToFives = quotient + (A % 10 / 5);
//        int trailingZerosDueToTens = 0;
//        while (quotient != 0) {
//            trailingZerosDueToTens += quotient;
//            quotient = quotient / 10;
//        }
//        return trailingZerosDueToFives + trailingZerosDueToTens;
        int ans=0;
        while(A>=5)
        {
            ans =ans+A/5;
            A=A/5;
        }
        return ans;
    }

}
