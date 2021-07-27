package math.adhoc;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/distribute-in-circle/
public class AdhocTotalMovesForBishop {

    public static void main(String[] args) {
        Assert.assertEquals(13, solve(4, 4));
        System.out.println("Success");
        System.out.println("Success");
    }

    public static int solve(int A, int B) {
        int leftTop = Math.min(B - 1, A - 1);
        int leftBottom = Math.min(B - 1, 8 - A);
        int rightTop = Math.min(8 - B, A - 1);
        int rightBottom = Math.min(8 - B, 8 - A);
        return leftTop + leftBottom + rightBottom + rightTop;
    }

}
