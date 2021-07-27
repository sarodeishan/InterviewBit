package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/flip/
public class ArrangementRotateMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(i);
            row.add(++i);
            row.add(++i);
            input.add(row);
        }
        rotate(input);
        System.out.println(input);
        System.out.println("Success");

        input = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(i);
            row.add(++i);
            input.add(row);
        }
        rotate(input);
        System.out.println(input);
        System.out.println("Success");

    }

    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        for (ArrayList<Integer> row : a) {
            Collections.reverse(row);
        }
        int startRow = 0, startCol = 0, endRow = a.size(), endCol = a.get(0).size();
        while (startRow != endRow && startCol != endCol) {
            int row1 = startRow, col1 = startCol, row2 = endRow - 1, col2 = endCol - 1;
            while (row1 != row2 && col1 != col2) {
                int temp = a.get(row1).get(col1);
                a.get(row1).set(col1, a.get(row2).get(col2));
                a.get(row2).set(col2, temp);
                col1++;
                row2--;
            }
            startRow++;
            endCol--;
        }
    }

}
