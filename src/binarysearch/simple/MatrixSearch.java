package binarysearch.simple;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/old/problems/matrix-search/
public class MatrixSearch {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        row1.add(7);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(10);
        row2.add(11);
        row2.add(16);
        row2.add(20);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(23);
        row3.add(30);
        row3.add(34);
        row3.add(50);

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        Assert.assertEquals(1, searchMatrix(rows, 3));
        System.out.println("Success");

        rows.clear();
        row1.clear();
        row2.clear();
        row3.clear();

        row1.add(5);
        row1.add(17);
        row1.add(100);
        row1.add(111);
        rows.add(row1);

        row2.add(119);
        row2.add(120);
        row2.add(127);
        row2.add(131);
        rows.add(row2);

        Assert.assertEquals(0, searchMatrix(rows, 3));
        System.out.println("Success");

        rows.clear();
        row1.clear();
        row2.clear();
        row3.clear();

        row1.add(2);
        row1.add(9);
        row1.add(12);
        row1.add(13);
        row1.add(16);
        row1.add(18);
        row1.add(18);
        row1.add(19);
        row1.add(20);
        row1.add(22);
        rows.add(row1);

        row2.add(29);
        row2.add(59);
        row2.add(62);
        row2.add(66);
        row2.add(71);
        row2.add(75);
        row2.add(77);
        row2.add(79);
        row2.add(97);
        row2.add(99);
        rows.add(row2);

        Assert.assertEquals(0, searchMatrix(rows, 45));
        System.out.println("Success");

        rows.clear();
        row1.clear();
        row2.clear();
        row3.clear();

        row1.add(88);
        row1.add(91);
        row1.add(92);
        row1.add(93);
        row1.add(94);
        rows.add(row1);

        Assert.assertEquals(1, searchMatrix(rows, 94));
        System.out.println("Success");

        rows.clear();
        row1.clear();
        row2.clear();
        row3.clear();

        row1.add(42);
        row1.add(51);
        rows.add(row1);

        row2.add(66);
        row2.add(83);
        rows.add(row2);
        Assert.assertEquals(1, searchMatrix(rows, 83));
        System.out.println("Success");

    }

    public static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int low = 0;
        int high = A.size() - 1;
        int rowIndex = -1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (A.get(mid).get(0) == B) {
                return 1;
            } else if (A.get(mid).get(0) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
                if (mid == rowIndex){
                    break;
                }
                rowIndex = mid;
            }
        }
        if (rowIndex ==-1){
            rowIndex = low;
        }

        low = 0;
        high = A.get(rowIndex).size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (A.get(rowIndex).get(mid) == B) {
                return 1;
            } else if (A.get(rowIndex).get(mid) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
