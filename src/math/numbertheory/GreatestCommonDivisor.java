package math.numbertheory;

import org.junit.Assert;

import java.math.BigDecimal;


//https://www.interviewbit.com/old/problems/greatest-common-divisor/
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        Assert.assertEquals(3, gcd(6,9));
        System.out.println("Success");
        Assert.assertEquals(4, gcd(0,4));
        System.out.println("Success");
    }

    public static int gcd(int A, int B) {
        int smallest = Math.min(A, B);
        if (smallest==0){
            return A+B-smallest;
        }
        int gcd = smallest;
        for (int i = smallest; i > 0 ; i--) {
            if (A%i == 0 && B%i==0){
                gcd = i;
                break;
            }
        }
        return gcd;
    }


}
