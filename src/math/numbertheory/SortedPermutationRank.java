package math.numbertheory;

import org.junit.Assert;

import java.util.*;
import java.util.stream.Stream;


//https://www.interviewbit.com/old/problems/sorted-permutation-rank/
public class SortedPermutationRank {

    public static void main(String[] args) {
        Assert.assertEquals(1, findRank("abc"));
        System.out.println("Success");
        Assert.assertEquals(2, findRank("acb"));
        System.out.println("Success");
        Assert.assertEquals(4, findRank("acdb"));
        System.out.println("Success");
        Assert.assertEquals(8, findRank("badc"));
        System.out.println("Success");
        Assert.assertEquals(342501, findRank("DTNGJPURFHYEW"));
        System.out.println("Success");
    }

    public static int findRank(String A) {
        Map<Integer, Integer> factMap = new HashMap<>();
        factMap.put(0, 1);
        factMap.put(1, 1);
        char[] sortedArr = A.toCharArray();
        Arrays.sort(sortedArr);
        String sorted = new String(sortedArr);
        int[] prevEncounteredCharCount = new int[A.length()];
        int result = 0;
        for (int i = 0; i < A.toCharArray().length; i++) {
            int charRank = sorted.indexOf(A.charAt(i));
            increaseCount(prevEncounteredCharCount, charRank + 1);
            result = result + factorial(A.length() - (i + 1), factMap) * (charRank - prevEncounteredCharCount[charRank]);
            result %= 1000003;
        }
        return result+1;
    }

    public static void increaseCount(int[] arr, int startIncIndex) {
        for (int i = startIncIndex; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }


    public static int factorial(int num, Map<Integer, Integer> factMap) {
        if (num == 0 || num == 1) {
            return 1;
        } else if (factMap.containsKey(num)) {
            return factMap.get(num);
        }
        return (num * factorial(--num, factMap)) % 1000003;
    }

}
