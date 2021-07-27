package binarysearch.simple;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/old/problems/woodcutting-made-easy/
public class WoodCuttingMadeEasy {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(20);
        arrayList.add(15);
        arrayList.add(10);
        arrayList.add(17);
        Assert.assertEquals(15, solve(arrayList, 7));
        System.out.println("Success");

        arrayList.clear();
        arrayList.add(4);
        arrayList.add(42);
        arrayList.add(40);
        arrayList.add(26);
        arrayList.add(46);
        Assert.assertEquals(36, solve(arrayList, 20));
        System.out.println("Success");

        arrayList.clear();
        arrayList.add(114);
        arrayList.add(55);
        arrayList.add(95);
        arrayList.add(131);
        arrayList.add(77);
        arrayList.add(111);
        arrayList.add(141);
        Assert.assertEquals(100, solve(arrayList, 95));
        System.out.println("Success");
    }

    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int maxHeightTree = A.get(A.size() - 1);
        int high = maxHeightTree;
        int low = maxHeightTree - B;
        int result = low;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            final int maxSawbladeHeight = mid;
            long cutWood = A.stream().mapToLong(Integer::longValue).map(operand -> operand - maxSawbladeHeight)
                    .filter(value -> value > 0).sum();
            if (cutWood == B) {
                result = mid;
                break;
            } else if (cutWood < B) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
//
//        for (int i = maxHeightTree; i >= maxHeightTree - B; i--) {
//            final int maxSawbladeHeight = i;
//            int cutWood = A.stream().mapToInt(Integer::intValue).map(operand -> operand - maxSawbladeHeight)
//                    .filter(value -> value >=0).sum();
//            if (cutWood >= B){
//                return maxSawbladeHeight;
//            }
//        }
//        return -1;
    }
}
