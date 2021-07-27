package math.adhoc;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/is-rectangle/
public class AdhocIsRectangle {

    public static void main(String[] args) {
        Assert.assertEquals(1, solve(1, 1, 2, 2));
        System.out.println("Success");
        Assert.assertEquals(0, solve(1, 1, 3, 4));
        System.out.println("Success");
    }

    public static int solve(int A, int B, int C, int D) {
        if (A <= 0 || B <= 0 || C <= 0 || D <= 0) {
            return 0;
        }
        if (A == B && C == D) {
            return 1;
        } else if (A == C && B == D) {
            return 1;
        } else if (A == D && B == C) {
            return 1;
        }
        return 0;
    }

}
