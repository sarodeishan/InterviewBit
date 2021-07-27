package math.numbertheory;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


//https://www.interviewbit.com/problems/find-nth-fibonacci/
public class FindNthFibonacci {

    public static void main(String[] args) {
        Assert.assertEquals(3, solve(4));
        System.out.println("Success");
        Assert.assertEquals(2, solve(3));
        System.out.println("Success");
        Assert.assertEquals(586268941, solve(50));
        System.out.println("Success");
    }

    public static int solve(int A) {
        Map<Integer, int[][]> knownMatrices = new HashMap<>();
        int[][] index = {{1, 0}, {0, 1}};
        knownMatrices.put(0, index);
        int[][] first = {{1, 1}, {1, 0}};
        knownMatrices.put(1, first);
        if (A == 1 || A == 2) {
            return 1;
        }
        int[][] aThFibonacciMatrix = findPower(first, A - 1, knownMatrices);
        return aThFibonacciMatrix[0][0];
    }

    public static int[][] findPower(int[][] matrix, int power, Map<Integer, int[][]> knownMatrices) {
        if (knownMatrices.containsKey(power)) {
            return knownMatrices.get(power);
        }
        int result[][] = multiplyMatrix(matrix, findPower(matrix, power - 1, knownMatrices));
        knownMatrices.put(power, result);
        return result;
    }

    public static int[][] multiplyMatrix(int[][] first, int[][] second) {
        int modulo = (int) (Math.pow(10, 9) + 7);
        int[][] result = new int[2][2];
        result[0][0] = (first[0][0] * second[0][0] + first[0][1] * second[1][0]) % modulo;
        result[0][1] = (first[0][0] * second[0][1] + first[0][1] * second[1][1]) % modulo;
        result[1][0] = (first[1][0] * second[0][0] + first[1][1] * second[1][0]) % modulo;
        result[1][1] = (first[1][0] * second[0][1] + first[1][1] * second[1][1]) % modulo;
        return result;
    }

}
