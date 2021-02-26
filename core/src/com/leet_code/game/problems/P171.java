package com.leet_code.game.problems;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 */
public class P171 {
    class Solution {
        public int titleToNumber(String s) {
            int output = 0;
            for(int i = 0; i < s.length();i++){
                //Breaks it down two parts
                //((s.charAt(i) - 'A') + 1) = gets the character value, 'A' - 'A' = 0 + 1
                //  since we're starting at A = 1;
                //Math.pow(26, s.length() - 1 - i) the first char will be highest power so
                //we go s.length() - 1 - i and then each full add is every 26 num.
                output += ((s.charAt(i) - 'A') + 1) * Math.pow(26, s.length() - 1 - i);
            }
            return output;
        }
    }
}
