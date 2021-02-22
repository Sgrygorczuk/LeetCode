package com.leet_code.game.problems;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 *
 *
 * Constraints:
 *
 * 1 <= word1.length, word2.length <= 100
 * word1 and word2 consist of lowercase English letters.
 */
public class P1768 {
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder output = new StringBuilder();
            int length = 0;

            //Depending on which is longer use that length for the adding of chars
            if(word1.length() < word2.length()){ length = word1.length(); }
            else{ length = word2.length(); }

            //Adds the chars to the output for as long as they're the same lenght
            for(int i = 0; i < length; i++){
                output.append(word1, i, i + 1);
                output.append(word2, i, i + 1);
            }

            //Whichever is longer just add the reminder to the end
            if(word1.length() < word2.length()){ output.append(word2, word1.length(), word2.length()); }
            else{ output.append(word1, word2.length(), word1.length()); }


            return String.valueOf(output);
        }

    }
}
