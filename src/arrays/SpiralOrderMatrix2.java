package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/spiral-order-matrix-ii/
public class SpiralOrderMatrix2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = generateMatrix(1);
        System.out.println(result);
        System.out.println("Success");

        result = generateMatrix(2);
        System.out.println(result);
        System.out.println("Success");
        result = generateMatrix(3);
        System.out.println(result);
        System.out.println("Success");
        result = generateMatrix(4);
        System.out.println(result);
        System.out.println("Success");

    }

    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                list.add(0);
            }
            result.add(list);
        }
        int maxNumber = A * A;
        int rowMin = 0, colMin = 0;
        int rowMax = A - 1, colMax = A - 1;
        int number = 1;
        while (number <= maxNumber) {
            //add left to right in columns in same row
            for (int i = colMin; i <= colMax; i++) {
                result.get(rowMin).set(i, number);
                number++;
            }
            rowMin++;
            //add up to down in rows in same column
            for (int i = rowMin; i <= rowMax; i++) {
                result.get(i).set(colMax, number);
                number++;
            }
            colMax--;
            //add right to left in columns in same row
            for (int i = colMax; i >= colMin; i--) {
                result.get(rowMax).set(i, number);
                number++;
            }
            rowMax--;
            //add down to up in rows in same column
            for (int i = rowMax; i >= rowMin; i--) {
                result.get(i).set(colMin, number);
                number++;
            }
            colMin++;
        }
        return result;
    }

}
