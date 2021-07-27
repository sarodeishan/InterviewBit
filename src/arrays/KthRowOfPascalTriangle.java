package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/
public class KthRowOfPascalTriangle {

    public static void main(String[] args) {
        ArrayList<Integer> result = getRow(0);
        System.out.println(result);
        System.out.println("Success");

        result = getRow(1);
        System.out.println(result);
        System.out.println("Success");

        result = getRow(2);
        System.out.println(result);
        System.out.println("Success");

        result = getRow(3);
        System.out.println(result);
        System.out.println("Success");

    }

    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A < 0) {
            return result;
        } else {
            for (int i = 0; i <=A ; i++) {
                result.add(0);
            }
            int rowCount = 1;
            result.set(0, 1);
            rowCount++;
            while (rowCount <= A + 1) {
                for (int i = rowCount-1; i >=0; i--) {
                    int topValue = result.get(i);
                    int previousTopValue = 0;
                    if ((i - 1) >= 0) {
                        previousTopValue = result.get(i - 1);
                    }
                    result.set(i, topValue + previousTopValue);
                }
                rowCount++;
            }
        }
        return result;
    }

}