package binarysearch.searchStepSimulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

//https://www.interviewbit.com/problems/simple-queries/
public class SimpleQueries {


    public static void main(String[] args) {
        ArrayList<Integer> integers = Arrays.asList(1, 2, 4).stream().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> queries = Arrays.asList(1, 2, 3, 4, 5, 6).stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(solve(integers, queries));
        System.out.println("Success");

        integers = Arrays.asList(1, 3).stream().collect(Collectors.toCollection(ArrayList::new));
        queries = Arrays.asList(1).stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(solve(integers, queries));
        System.out.println("Success");

        integers = Arrays.asList(39, 99, 70, 24, 49, 13, 86, 43, 88, 74, 45, 92, 72, 71, 90, 32, 19, 76, 84, 46, 63, 15, 87, 1, 39, 58, 17, 65, 99, 43, 83, 29, 64, 67, 100, 14, 17, 100, 81, 26, 45, 40, 95, 94, 86, 2, 89, 57, 52, 91, 45 ).stream().collect(Collectors.toCollection(ArrayList::new));
        queries = Arrays.asList( 1221, 360, 459, 651, 958, 584, 345, 181, 536, 116, 1310, 403, 669, 1044, 1281, 711, 222, 280, 1255, 257, 811, 409, 698, 74, 838).stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(solve(integers, queries));
        System.out.println("Success");
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> productMemory = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                A.subList(i, j + 1).parallelStream().mapToInt(Integer::intValue).max()
                        .ifPresent(value -> temp.add(factorsProducts(value, productMemory)));
            }
        }
        ArrayList<Integer> descending = temp.parallelStream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
        return B.stream().map(index -> index - 1).map(descending::get).collect(Collectors.toCollection(ArrayList::new));
    }

    public static int factorsProducts(int number, HashMap<Integer, Integer> productMemory) {
        if (productMemory.containsKey(number)) {
            return productMemory.get(number);
        }
        long mod = (int)1e9+7;
        long product = 1;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                product = (product * i) % mod;
            }
        }
        product = product % mod;
        productMemory.put(number, (int)product);
        return (int)product;
    }
}
