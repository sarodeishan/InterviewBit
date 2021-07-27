package math.numberencoding;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;


//https://www.interviewbit.com/problems/rearrange-array/
public class RearrangeArray {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(0);
        arrange(input);
        System.out.println(input);
        System.out.println("Success");
        input.clear();
        input.add(4);
        input.add(0);
        input.add(2);
        input.add(1);
        input.add(3);
        arrange(input);
        System.out.println(input);
    }

    public static void arrange(ArrayList<Integer> a) {
        int n = a.size();
        //encoding so that set the index value 'old' will become 'old + (new%n)*n'
        //hence for fetching a new number we can take encodedValue/n
        //hence for fetching a old number we can take encodedValue%n
        for (int i = 0; i < a.size(); i++) {
            a.set(i, (a.get(i) + (a.get(a.get(i)) % n) * n));
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }

}
