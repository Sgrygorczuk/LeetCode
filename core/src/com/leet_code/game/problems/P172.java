package com.leet_code.game.problems;

import com.badlogic.gdx.math.MathUtils;

import java.text.DecimalFormat;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 *
 * Input: n = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 104
 */
public class P172 {
    class Solution {
        public int trailingZeroes(int n) {
            int counter = 0;

            /*
            So we want to find how many times this is divisible by 5
            Since ever 5 or so we add a 0, anything between 1-4 has no trailing 0
            Anything between 5-9 has 1 trailing zero and so on incrementing with 5s.

            So what we do is we count how many times we can keep dividing by 5,
            Ex. n = 30, we do 30/5 = 6, so we have 6 zeros there now we still have
            a 6 so we can divide it one more time and have 1 extra zero.
            This way we have 7 zeroes total
             */
            while (n >= 5) {
                counter += n/5;
                n /= 5;
            }

            return counter;
        }
    }
}
