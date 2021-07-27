package binarysearch.searchStepSimulation;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/implement-power-function/
public class ImplementPowerFunction {


    public static void main(String[] args) {
        Assert.assertEquals((int) (Math.pow(2, 3) % 3), pow(2, 3, 3));
        System.out.println("Success");
        Assert.assertEquals((int) (Math.pow(-1, 1) % 20), pow(-1, 1, 20));
        System.out.println("Success");
//        Assert.assertEquals(9400003, pow(1, 1000000,input));
//        System.out.println("Success");
    }

    public static int pow(int x, int n, int d) {
//        return (int) (Math.pow(x, n) % d);
        long power = 1;
        for (int i = 1; i <= n; i++) {
            power = power * x;
        }
        long answer = power;
        while (answer >= d) {
            answer -= d;
        }
        return (int) answer;
    }
}
