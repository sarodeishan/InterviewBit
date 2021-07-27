package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/maximum-consecutive-gap/
public class MaximumConsecutiveGap {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(1, 10, 5);
        int result = maximumGap(A);
        Assert.assertEquals("Failed", 5, result);
        System.out.println("Success");

        A = Arrays.asList(1, 10, 21, 33, 45);
        result = maximumGap(A);
        Assert.assertEquals("Failed", 12, result);
        System.out.println("Success");
        Collections.sort(A);
//
//        A = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
//        result = maximumGap(A);
//        Assert.assertEquals("Failed", 1, result);
//        System.out.println("Success");
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static int maximumGap(final List<Integer> A) {
        if (A.size() < 2) {
            return 0;
        }

        List<Integer> maxHeap = new ArrayList<>();
        maxHeap.addAll(A);
        buildMaxHeap(maxHeap);

        int maxDiff = 0;
        int maxNumber = extractHeapMax(maxHeap);
        while (maxHeap.size() > 0) {
            int secondMaxNumber = extractHeapMax(maxHeap);
            maxDiff = Math.max(maxDiff, maxNumber - secondMaxNumber);
            maxNumber = secondMaxNumber;
        }
        return maxDiff;
    }

    public static void maxHeapify(List<Integer> list, int heapSize, int index) {
        int left = 2 * index + 1;
        int right = 2 * (index + 1);
        int largest = index;
        if (left <= heapSize && list.get(left) > list.get(index)) {
            largest = left;
        }
        if (right <= heapSize && list.get(right) > list.get(largest)) {
            largest = right;
        }
        if (largest != index) {
            int temp = list.get(index);
            list.set(index, list.get(largest));
            list.set(largest, temp);
            maxHeapify(list, heapSize, largest);
        }
    }

    public static void buildMaxHeap(List<Integer> list) {
        int heapSize = list.size()-1;
        for (int i = (heapSize) / 2; i >= 0; i--) {
            maxHeapify(list, heapSize, i);
        }
    }

    public static int extractHeapMax(List<Integer> list) {
        int heapSize = list.size()-1;
        int max = list.get(0);
        list.set(0, list.get(heapSize));
        list.remove(list.size() - 1);
        heapSize--;
        maxHeapify(list, heapSize, 0);
        return max;
    }

}
