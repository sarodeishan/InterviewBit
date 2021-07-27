package arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.interviewbit.com/problems/maximum-area-of-triangle/
public class MaximumAreaOfTriangle {

    public static void main(String[] args) {
        List<String> A = Arrays.asList("rrrrr", "rrrrg", "rrrrr", "bbbbb");
        int result = solve(A);
        Assert.assertEquals("Failed", 10, result);
        System.out.println("Success");

        A = Arrays.asList("rrr", "rrr", "rrr", "rrr");
        result = solve(A);
        Assert.assertEquals("Failed", 0, result);
        System.out.println("Success");


        A = Arrays.asList("bbrbbb", "brgrbb", "rbbggb", "rggggr", "rrggrb", "grrbrg", "gbbrrg", "grgrbb", "bbbrgr", "bbrrgg", "rggrbg", "rrgggg", "ggbbgb", "grggbb", "rrrbrr", "rrrbrb", "bbbbbb", "rbbbrg", "ggbbbg", "ggbggr", "bggrgb", "bbrrrb", "rbrrbb", "brbgrg", "rbrrrg", "bbrrgg", "rbgrgg");
        result = solve(A);
        Assert.assertEquals("Failed", 81, result);
        System.out.println("Success");

        A = Arrays.asList("rbrrggggbbbrgrrbr", "bbrrgbrbrgbrrgbbg", "ggbrggrrgrrgbrrrg", "rrrbgggbbggrrbgbr", "bbggggrbrgggrrbgg", "rrrbbgbgrrbrrgrbg", "gbbbrgbggrgbbrbgg", "bgbgrgbrbrgbrgggr", "bgbggrrrbrrgbrgbb", "brbggbbrrbgbrrgrb", "ggbbgbbbgbrbbbgbg", "gbrrbgrbrbgrrrgbg", "bgbrbbgrgbgrrrbgr", "brrgggbbgrrbgrbbg", "bbbrrbbbrbggrrbbr", "rrrrbgrbgrrbbrbbr", "gbggggrrrbrbggbgg", "grbgbbgrggrrrgbbg", "grgggbggbrgrgrgrb", "ggrrgrbggbrbggrbr", "ggbbbrgrbgbrggrgb", "grgbggrbrrrgrbbbg", "bbrrbrrbgbrrggbgg", "rrgrrgbggbbbgbggr", "rgrbrbrbgrbrrrrgg", "rgrbrbgrgrggbbrgr", "brgrggrgrgbgrrggg", "grbggrrbbrrgrgbgg", "rgrbbrbrgggrgrrbg" );
        result = solve(A);
        Assert.assertEquals("Failed", 247, result);
        System.out.println("Success");

    }

    public static int solve(List<String> A) {
        class Point {
            char color;
            int x;
            int y;

            Point(char color, int x, int y) {
                this.color = color;
                this.x = x;
                this.y = y;
            }
        }
        Point a = null, b = null, c = null;
        int maxArea = Integer.MIN_VALUE;
        //iterating over streams X-axis
        for (int i = 0; i < A.get(0).length(); i++) {
            a = new Point(A.get(0).charAt(i), i, 0);
            b = null;
            c = null;
            //iterating over list Y-axis
            for (int j = A.size() - 1; j > 0; j--) {
                if (A.get(j).charAt(i) != a.color) {
                    b = new Point(A.get(j).charAt(i), i, j);
                    break;
                }
            }
            //iterating over streams X-axis to find last point
            for (int j = A.get(0).length() - 1; b != null && j > i; j--) {
                //iterating over list Y-axis
                for (int k = 0; k < A.size(); k++) {
                    char temp = A.get(k).charAt(j);
                    if (temp != a.color && temp != b.color) {
                        c = new Point(temp, j, k);
                        System.out.print("A=("+(a.x+1)+","+(a.y+1)+")");
                        System.out.print("B=("+(b.x+1)+","+(b.y+1)+")");
                        System.out.print("C=("+(c.x+1)+","+(c.y+1)+")");
                        maxArea = Math.max(maxArea, areaOfTriangle(a.x + 1, a.y + 1, b.x + 1, b.y + 1, c.x + 1, c.y + 1));
                        System.out.println("area="+maxArea);
                    }
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    public static int areaOfTriangle(int ax, int ay, int bx, int by, int cx, int cy) {
        int base = Math.abs(ay - by)+1;
        int height = Math.abs(ax - cx)+1;
        System.out.print("base="+base+" height="+height+" ");
        return (int) Math.round(Math.ceil(base * height) / 2);
    }

}
