package arrays;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/add-one-to-number/
public class PascalTriangle {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = solve(5);
        System.out.println(result);
        System.out.println("Success");
    }

    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int rows = 0;
        if (A <= 0) {
            return result;
        } else {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            result.add(row);
            rows++;
        }
        //loop is to add rows
        while (rows < A) {
            //loop is to create a row
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i <= rows; i++) {
                row.add(calculateRowValue(result.get(rows - 1), i));
            }
            result.add(row);
            rows++;
        }
        return result;
    }

    public static int calculateRowValue(final ArrayList<Integer> previousRow, final int targetIndex) {
        int topValue = 0;
        int previousTopValue = 0;
        if (targetIndex >= 0 && targetIndex <= (previousRow.size() - 1)) {
            topValue = previousRow.get(targetIndex);
        }
        if ((targetIndex - 1) >= 0 && (targetIndex - 1) <= (previousRow.size() - 1)) {
            previousTopValue = previousRow.get(targetIndex - 1);
        }
        return topValue + previousTopValue;
    }

}
