package arrays;

import com.sun.deploy.ui.DialogTemplate;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/minimum-lights-to-activate/
public class MinimumLightsToActivate {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(0, 0, 1, 1, 1, 0, 0, 1);
        int B = 3;
        Assert.assertEquals("Failed", 2, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(0, 0, 0, 1, 0);
        B = 3;
        Assert.assertEquals("Failed", -1, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(1, 0, 0, 1);
        B = 3;
        Assert.assertEquals("Failed", 2, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(1, 0, 0, 0, 0, 1);
        B = 3;
        Assert.assertEquals("Failed", 2, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0);
        B = 12;
        Assert.assertEquals("Failed", 2, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(1, 1, 1, 1);
        B = 3;
        Assert.assertEquals("Failed", 1, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(1, 1, 1, 1, 1, 0, 0);
        B = 3;
        Assert.assertEquals("Failed", 2, solve(A, B));
        System.out.println("Success");
        A = Arrays.asList(0, 0, 1, 1);
        B = 2;
        Assert.assertEquals("Failed", -1, solve(A, B));
        System.out.println("Success");
    }

    public static int solve(List<Integer> A, int B) {
        int window = B - 1;
        int lightsRequired = 0;
        for (int i = 0; i < A.size(); i++) {
            int windowMax = (i + window) < A.size() ? (i + window) : A.size() - 1;
            int windowMin = (i - window) > 0 ? (i - window) : 0;
            int j = windowMax;
            for (; j >= windowMin; j--) {
                if (A.get(j) == 1) {
                    //ideal bulb location found
                    lightsRequired++;
                    i = j + window;
                    break;
                }
            }
            if (j == windowMin-1){
                lightsRequired = -1;
                break;
            }
        }
        return lightsRequired;
    }

}
