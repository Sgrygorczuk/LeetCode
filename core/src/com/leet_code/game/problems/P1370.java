package com.leet_code.game.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * Example 2:
 *
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: "cdelotee"
 * Example 4:
 *
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 * Example 5:
 *
 * Input: s = "spo"
 * Output: "ops"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 */
public class P1370 {
    class Solution {
        public String sortString(String s) {
            int[] alphabet = new int[26];               //Keeps track of all the chars given
            boolean lookingSmallest = true;             //Tells us if we're going up or down the alphabet
            StringBuilder result = new StringBuilder(); //Result to be given

            //Used to gather all the chars in the given word
            for(int i = 0; i < s.length(); i++){
                alphabet[s.charAt(i) - 97]++;
            }

            while(result.length() < s.length()) {
                if (lookingSmallest) {
                    //Stage 1 append the chars going up in correspond ascii value
                    for (int i = 0; i < alphabet.length; i++) {
                        if (alphabet[i] > 0) {
                            result.append((char) ('a' + i));
                            alphabet[i]--;
                        }
                    }
                }
                else{
                    //Stage 2 append all the chars going down ascii values
                    for (int i = 0; i < alphabet.length; i++) {
                        if (alphabet[alphabet.length - 1 - i] > 0) {
                            result.append((char) ('z' - i));
                            alphabet[alphabet.length - 1 - i]--;
                        }
                    }
                }
                //Switch which way we are searching
                lookingSmallest = !lookingSmallest;
            }

            return result.toString();
        }
    }
}
