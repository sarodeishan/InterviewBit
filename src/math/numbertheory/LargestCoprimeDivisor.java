package math.numbertheory;

import org.junit.Assert;


//https://www.interviewbit.com/problems/largest-coprime-divisor/
public class LargestCoprimeDivisor {

    public static void main(String[] args) {
        Assert.assertEquals(5, cpFact(30, 12));
        System.out.println("Success");
    }

    public static int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A = A / gcd(A, B);
        }
        return A;
    }

    public static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

}
