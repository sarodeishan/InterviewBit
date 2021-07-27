package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/flip/
public class Flip {

    public static void main(String[] args) {
        List<Integer> result = flip("010");
        System.out.println(result);
        System.out.println("Success");

        result = flip("111");
        System.out.println(result);
        System.out.println("Success");

    }

    public static ArrayList<Integer> flip(String A) {
        //think for kadane's algo
        int arr[] = new int[A.length()];
        boolean flag = false;

        //what we need to do here is make 1 to -1 and 0 to 1.Why??
        //as we need to  maximize the number 1 in A string,this can be only done on zeros
        //so if we are able to find the substring that have maxm number of zero(1 converted  //above) wll got our ans.
        //

        for (int i = 0; i < arr.length; i++) {
            arr[i] = A.charAt(i) - '0' == 1 ? -1 : 1;
        }

        int currSum = 0;
        int maxSum = 0;
        int temp_start = 0, start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (maxSum < currSum) {
                maxSum = currSum;
                end = i;
                start = temp_start;
                flag = true;
            }
            if (currSum < 0) {
                currSum = 0;
                temp_start = i + 1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (flag == false) return result;

        result.add(start + 1);
        result.add(end + 1);
        return result;
    }

}
