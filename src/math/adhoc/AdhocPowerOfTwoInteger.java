package math.adhoc;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/power-of-two-integers/
public class AdhocPowerOfTwoInteger {

    public static void main(String[] args) {
        Assert.assertEquals(1, isPower(4));
        System.out.println("Success");
        Assert.assertEquals(1, isPower(27));
        System.out.println("Success");
        Assert.assertEquals(0, isPower(71));
        System.out.println("Success");
    }

    public static int isPower(int A) {
        if (A==1) {
            return 1;
        }
        for (int i = 2; i <= A / 2; i++) {
            int res = i;
            int pow=1;
            while (res < A) {
                res = (int) Math.pow(i, pow);
                pow++;
            }
            if (res == A) {
                return 1;
            }
        }
        return 0;
    }

}
