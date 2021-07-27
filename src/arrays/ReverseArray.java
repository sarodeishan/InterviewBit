package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result[] = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Assert.assertArrayEquals(result, inPlaceSwap(Arrays.stream(a).toArray()));
        Assert.assertArrayEquals(result, newArrayReverse(Arrays.stream(a).toArray()));
        Assert.assertArrayEquals(result, newCollectionReverse(Arrays.stream(a).toArray()));
        Assert.assertArrayEquals(result, invertArray(Arrays.stream(a).toArray()));
    }

    public static int[] newCollectionReverse(int[] a) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) { result.add(a[i]); }
        Collections.reverse(result);
        return result.stream().mapToInt(value -> value.intValue()).toArray();
    }

    public static int[] invertArray(int[] a) {
        return IntStream.range(0, a.length).map(i -> a[a.length - 1 - i]).toArray();
    }

    public static int[] newArrayReverse(int[] a) {
        int[] result = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) { result[a.length - 1 - i] = a[i]; }
        return result;
    }

    public static int[] inPlaceSwap(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) { swap(a, i, j); }
        return a;
    }

    public static void swap(int a[], int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }
}
