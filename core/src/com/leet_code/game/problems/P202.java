package com.leet_code.game.problems;

import com.badlogic.gdx.math.MathUtils;

/**
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class P202 {
    class Solution {
        public boolean isHappy(int n) {
            //Does a counter to see if it occurs within first 100 attempts otherwise fail
            int counter = 0;
            //Keeps doing it till anweser is 1 or we did all the tries
            while (n != 1 && counter < 100) {
                n = breakDown(n);
                counter++;
            }
            return counter != 100;
        }

        /**
         * Breaks down the number into single digits, squares them and sums them
         *
         * @param n given digit
         * @return a squared sum of all individual digits
         */
        public int breakDown(int n) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            return sum;
        }
    }
}
