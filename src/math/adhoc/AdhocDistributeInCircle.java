package math.adhoc;

import org.junit.Assert;

//https://www.interviewbit.com/old/problems/distribute-in-circle/
public class AdhocDistributeInCircle {

    public static void main(String[] args) {
        Assert.assertEquals(2, solve(2, 5, 1));
        System.out.println("Success");
        Assert.assertEquals(4, solve(8, 5, 2));
        System.out.println("Success");
        Assert.assertEquals(5, solve(10, 5, 1));
        System.out.println("Success");
    }

    public static int solve(int A, int B, int C) {
        int lastPlaceByNumber = A + (C - 1);
        int lastPlaceByCircle = lastPlaceByNumber % B;
        lastPlaceByCircle = lastPlaceByCircle == 0 ? B : lastPlaceByCircle;
        return lastPlaceByCircle;
    }

}
