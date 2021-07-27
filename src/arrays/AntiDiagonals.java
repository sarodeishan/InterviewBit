package arrays;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/anti-diagonals/
public class AntiDiagonals {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList();
        ArrayList<Integer> row = new ArrayList<>();
        Collections.addAll(row, 1, 2, 3);
        input.add((ArrayList<Integer>) row.clone());
        row.clear();
        Collections.addAll(row, 4, 5, 6);
        input.add((ArrayList<Integer>) row.clone());
        row.clear();
        Collections.addAll(row, 7, 8, 9);
        input.add((ArrayList<Integer>) row.clone());
        ArrayList<ArrayList<Integer>> result = diagonal(input);
        System.out.println(result);
        System.out.println("Success");

        input = new ArrayList();
        row = new ArrayList<>();
        Collections.addAll(row, 1, 2);
        input.add((ArrayList<Integer>) row.clone());
        row.clear();
        Collections.addAll(row, 3, 4);
        input.add((ArrayList<Integer>) row.clone());
        result = diagonal(input);
        System.out.println(result);
        System.out.println("Success");

    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A.size() == 0) {
            return result;
        }
        //traverse x-axis
        for (int i = 0; i < A.get(0).size(); i++) {
            ArrayList<Integer> antiDiagonal = new ArrayList<>();
            int col = i;
            for (int row = 0; row < A.size() && col >= 0; row++, col--) {
                antiDiagonal.add(A.get(row).get(col));
            }
            result.add(antiDiagonal);
        }
        //traverse y-axis
        for (int i = 1; i < A.size(); i++) {
            ArrayList<Integer> antiDiagonal = new ArrayList<>();
            int row = i;
            for (int col = A.get(0).size()-1; row < A.size() && col >= 0; row++, col--) {
                antiDiagonal.add(A.get(row).get(col));
            }
            result.add(antiDiagonal);
        }

        return result;
    }
}