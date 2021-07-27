package binarysearch.simple;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/old/problems/sorted-insert-position/
public class SortedInsertPosition {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(6);

        Assert.assertEquals(2, searchInsert(arrayList, 5));
        System.out.println("Success");

        Assert.assertEquals(1, searchInsert(arrayList, 2));
        System.out.println("Success");

    }

    public static int searchInsert(ArrayList<Integer> a, int b) {
        int low = 0;
        int high = a.size()-1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) < b) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
