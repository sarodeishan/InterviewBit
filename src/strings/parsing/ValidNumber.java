package strings.parsing;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

//https://www.interviewbit.com/problems/valid-number/
public class ValidNumber {

    public static void main(String[] args) {
        Assert.assertEquals(0, isNumber("1u"));
        System.out.println("Success1");
        Assert.assertEquals(1, isNumber("0.1e10"));
        System.out.println("Success2");
        Assert.assertEquals(1, isNumber("-01.1e-10"));
        System.out.println("Success3");
        Assert.assertEquals(0, isNumber("0xFF"));
        System.out.println("Success4");
        Assert.assertEquals(0, isNumber("3e0.1"));
        System.out.println("Success5");
        Assert.assertEquals(0, isNumber("1f"));
        System.out.println("Success6");
        Assert.assertEquals(0, isNumber("1000L"));
        System.out.println("Success7");
        Assert.assertEquals(1, isNumber("008"));
        System.out.println("Success8");
        Assert.assertEquals(1, isNumber("+1"));
        System.out.println("Success9");
        Assert.assertEquals(1, isNumber(" 0.1"));
        System.out.println("Success10");
        Assert.assertEquals(0, isNumber("3."));
        System.out.println("Success11");
        Assert.assertEquals(0, isNumber("    "));
        System.out.println("Success12");
    }

    public static int isNumber(final String A) {
        boolean validNumber = true;
        String input = A.trim();

        List<Character> numbers = new ArrayList<>(10);
        numbers.add('0');numbers.add('1');numbers.add('2');
        numbers.add('3');numbers.add('4');numbers.add('5');
        numbers.add('6');numbers.add('7');numbers.add('8');
        numbers.add('9');

        Map<Character, Integer> allowedCharactersCount = new HashMap<>(20);
        allowedCharactersCount.put('-', 2);
        allowedCharactersCount.put('+', 2);
        allowedCharactersCount.put('e', 1);
        allowedCharactersCount.put('.', 1);
        numbers.parallelStream().forEach(character -> allowedCharactersCount.put(character, Integer.MAX_VALUE));

        Map<Character, Integer> charactersCount = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!allowedCharactersCount.containsKey(c)) {
                validNumber = false;
                break;
            }
            charactersCount.merge(c, 1, Integer::sum);

            if (c == 'e') {
                //an exponential cannot be on end
                if (i == input.length() - 1) {
                    validNumber = false;
                    break;
                }
            } else if (c == '.') {
                //an exponential cannot be followed by a decimal
                if (charactersCount.containsKey('e')) {
                    validNumber = false;
                    break;
                }
                //a decimal should be followed by a number
                if (i == input.length() - 1 || !numbers.contains(input.charAt(i + 1))) {
                    validNumber = false;
                    break;
                }
            } else if (c == '+' || c == '-') {
                //a sign should be followed by a number
                if (i == input.length() - 1 || !numbers.contains(input.charAt(i + 1))) {
                    validNumber = false;
                    break;
                }
            }
        }
        if (validNumber){
            validNumber = !charactersCount.isEmpty() && charactersCount.entrySet().stream().allMatch(entry -> entry.getValue() <= allowedCharactersCount.get(entry.getKey()));
        }
        return validNumber ? 1 : 0;
    }
}
