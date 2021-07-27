package binarysearch.simple;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/old/problems/search-for-a-range/
public class SearchForARange {


    public static void main(String[] args) {

        System.out.println(searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 8));
        System.out.println("Success");

        System.out.println(searchRange(Arrays.asList(5, 17, 100, 111), 3));
        System.out.println("Success");


    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int low = 0, high = A.size() - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (A.get(mid) == B) {
                //start position
                int start = mid;
                for (int i = start; i >= 0; i--) {
                    if (A.get(i) != B) {
                        break;
                    } else {
                        start = i;
                    }
                }
                result.add(start);
                //end position
                int end = mid;
                for (int i = end; i <= high; i++) {
                    if (A.get(i) != B) {
                        break;
                    } else {
                        end = i;
                    }
                }
                result.add(end);
                return result;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }
}
