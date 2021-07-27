package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//https://www.interviewbit.com/problems/set-matrix-zeros/
public class SetMatrixZeros {

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        A.add(Arrays.asList(1, 0,1));
        A.add(Arrays.asList(1, 1,1));
        A.add(Arrays.asList(1, 1,1));
        setZeroes(A);
        System.out.println(A);
        System.out.println("Success");


    }

    public static void setZeroes(List<List<Integer>> a) {
        HashSet<Integer> zeroRow = new HashSet<>();
        HashSet<Integer> zeroColumn = new HashSet<>();
        for (int row = 0; row < a.size(); row++) {
            for (int col = 0; col < a.get(row).size(); col++) {
                if (a.get(row).get(col)==0){
                    zeroRow.add(row);
                    zeroColumn.add(col);
                }
            }
        }
        setZeroRow(a, zeroRow);
        setZeroColumn(a, zeroColumn);
    }

    public static void setZeroRow(List<List<Integer>> a, HashSet<Integer> zeroRows){
        for (Integer i: zeroRows) {
            List<Integer> row = a.get(i);
            for (int col = 0; col < row.size(); col++) {
                row.set(col, 0);
            }
        }
    }

    public static void setZeroColumn(List<List<Integer>> a, HashSet<Integer> zeroCols){
        for (Integer i: zeroCols) {
            for (int row = 0; row < a.size(); row++) {
                a.get(row).set(i, 0);
            }
        }
    }
}
