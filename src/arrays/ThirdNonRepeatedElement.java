package arrays;

import org.junit.Assert;

import java.util.HashMap;

public class ThirdNonRepeatedElement {

    public static void main(String[] args) {
        String input = "Bhargava";
        Assert.assertEquals("Failed", "r", thirdNonRepeatedElement(input).toString());
        input = "Bhaaargv";
        Assert.assertEquals("Failed", "r", thirdNonRepeatedElement(input).toString());
        input = "Ishan";
        Assert.assertEquals("Failed", "h", thirdNonRepeatedElement(input).toString());
        input = "Nitish";
        Assert.assertEquals("Failed", "s", thirdNonRepeatedElement(input).toString());
        input = "cool";
        Assert.assertEquals("Failed", null, thirdNonRepeatedElement(input));
    }

    public static Character thirdNonRepeatedElement(String s) {
        Character result = null;
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }
        }
        int nonRepeatedChar = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (count.get(s.charAt(i)) == 1) {
                nonRepeatedChar++;
                if (nonRepeatedChar == 3) {
                    result = s.charAt(i);
                    break;
                }
            }
        }
        return result;
    }

}
