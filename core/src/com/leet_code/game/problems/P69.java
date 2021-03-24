package com.leet_code.game.problems;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
public class P69 {
    class Solution {
        public int mySqrt(int x) {
            //Correctly executed my idea
            if(x == 0) return 0;
            if(x < 4) return 1;
            int min = 1;
            int max = x;
            while(min < max) {
                int mid = min + (max - min) / 2;
                //Checking the square, is mid less than x/mid if yes, increase min
                if(mid <= x / mid) { min = mid + 1; }
                //If not shift max to be lower
                else { max = mid; }
            }
            return min - 1;
        }

        /**
         * Idea behind it was to keep cutting in half till we find someplace it settles but I'm jist
         * not getting it right
         */
        public int midSection(int x) {
            int counter = 0;
            int oldCounter = 1;
            int max = x;
            int min = 0;
            int mid = x / 2;
            while (true) {
                oldCounter = counter;
                int upper = (max + mid) / 2;
                int lower = (mid - min) / 2;
                System.out.println("U " + upper);
                System.out.println("L " + lower);
                if (x - (upper * upper) < x - (lower * lower) && x >= (upper * upper)) {
                    counter = upper;
                    min = mid;
                } else {
                    counter = lower;
                    max = mid;
                }
                mid = (max - min) / 2;
                if (x - (oldCounter * oldCounter) < x - (counter * counter) && x >= (oldCounter * oldCounter)) {
                    return oldCounter + 1;
                }
                if (oldCounter == counter && counter * counter <= x) {
                    return counter + 1;
                }
            }
        }
    }
}
