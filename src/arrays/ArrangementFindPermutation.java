package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.interviewbit.com/problems/find-permutation/
public class ArrangementFindPermutation {

    public static void main(String[] args) {

        String input = "ID";
        System.out.println(findPerm(input, 3));
        System.out.println("Success");

        input = "DDDDIIIDI";
        System.out.println(findPerm(input, 10));
        System.out.println("Success");

        input = "IIIIDDDID";
        System.out.println(findPerm(input, 10));
        System.out.println("Success");

    }
//
//    public static ArrayList<Integer> findPerm(final String A, int B) {
//        ArrayList<Integer> result = new ArrayList<>();
//        int[] suffixCountChar = new int[B];
//        int suffixI = 0;
//        int suffixD = 0;
//        for (int i = A.length() - 1; i >= 0; i--) {
//            if (A.charAt(i) == 'I') {
//                suffixCountChar[i] = suffixI;
//                suffixI++;
//            } else if (A.charAt(i) == 'D') {
//                suffixCountChar[i] = suffixD;
//                suffixD++;
//            }
//        }
//        result.add(A.charAt(0) == 'I' ? (B - (suffixCountChar[0] + 1)) : (suffixCountChar[0] + 2));
//        for (int i = 0; i < A.length(); i++) {
//            if (A.charAt(i) == 'I') {
//                result.add(B - suffixCountChar[i]);
//            } else if (A.charAt(i) == 'D') {
//                result.add(suffixCountChar[i] + 1);
//            }
//        }
//        return result;
//    }


    public static ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Character firstChar = A.charAt(0);
        int limit = 1;
        for (int i = 0; i < A.length(); i++) {
            if (firstChar == A.charAt(i)) {
                limit++;
            }
        }
        limit = firstChar == 'D' ? limit : B - limit;
        int numberD = limit, numberI = limit + 1;
        if (firstChar == 'D') {
            result.add(numberD--);
        } else {
            result.add(numberI++);
        }
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') {
                result.add(numberD--);
            } else {
                result.add(numberI++);
            }
        }
        return result;
    }

}
