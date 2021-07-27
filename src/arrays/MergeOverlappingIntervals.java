package arrays;

import org.junit.Assert;

import java.util.*;

//https://www.interviewbit.com/old/problems/merge-overlapping-intervals/
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        List<Interval> A = Arrays.asList(new Interval(1,3), new Interval(2,6), new Interval(8,10),
                new Interval(15,18));
        ArrayList<Interval> result = merge(A);
        System.out.println(result);
        System.out.println("Success");

    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public static ArrayList<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()){
            return result;
        }
        intervals.sort((o1, o2) -> Integer.valueOf(o1.start).compareTo(o2.start));
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval previous = result.get(result.size()-1);
            Interval next = intervals.get(i);
            if (previous.end >= next.start){
                result.remove(result.size()-1);
                result.add(new Interval(Math.min(previous.start, next.start), Math.max(previous.end, next.end)));
            } else {
                result.add(next);
            }
        }
        return result;
    }

}
