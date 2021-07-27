package binarysearch.sortModification;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Collectors;

//https://www.interviewbit.com/old/problems/rotated-sorted-array-search/
public class RotatedSortedArraySearch {


    public static void main(String[] args) {
        Assert.assertEquals(0, search(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3), 4));
        System.out.println("Success");

        Assert.assertEquals(-1, search(Arrays.asList(5, 17, 100, 3), 6));
        System.out.println("Success");
    }

    public static int search(final List<Integer> A, int B) {
        int partition = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                partition = i;
                break;
            }
        }
        int resultIndex = -1;
        int low = 0, high = partition;
        if (B <= A.get(A.size() - 1) && B >= A.get(partition + 1)) {
            low = partition + 1;
            high = A.size() - 1;
        }
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (A.get(mid) == B) {
                resultIndex = mid;
                break;
            } else if (A.get(mid) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return resultIndex;

    }

}
