package strings.simulation;

import org.junit.Assert;

import java.util.ArrayList;

public class LongestCommonPrefix {


    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>();
        input.add("abcdefgh");
        input.add("aefghijk");
        input.add("abcefgh");
        Assert.assertEquals("a", longestCommonPrefix(input));
        System.out.println("Success");
        input.clear();
        input.add("abab");
        input.add("ab");
        input.add("abcd");
        Assert.assertEquals("ab", longestCommonPrefix(input));
        System.out.println("Success");
    }

    public static String longestCommonPrefix(ArrayList<String> A) {
        if (A.size()==1){
            return A.get(0);
        }
        StringBuilder result = new StringBuilder("");
        int index = 0;
        while (index < A.get(0).length()) {
            boolean closeLoop = false;
            char c = A.get(0).charAt(index);

            for (int i = 1; i < A.size(); i++) {
                if (!(index < A.get(i).length() && A.get(i).charAt(index) == c)) {
                    closeLoop = true;
                    break;
                }
            }
            if (closeLoop) {
                break;
            } else {
                index++;
                result.append(c);
            }
        }
        return result.toString();
    }


}
