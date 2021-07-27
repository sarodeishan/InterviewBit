package math.adhoc;

import org.junit.Assert;

import java.util.ArrayList;

//https://www.interviewbit.com/old/problems/fizzbuzz/
public class AdhocFizzBuzz {

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println("Success");
        System.out.println(fizzBuzz(5));
        System.out.println("Success");
    }

    public static ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            String value="";
            if (i%3==0){
                value +="Fizz";
            }
            if (i%5==0){
                value+="Buzz";
            }
            if (value == ""){
                value +=i;
            }
            result.add(value);
        }
        return result;
    }

}
