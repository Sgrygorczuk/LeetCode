package com.leet_code.game.problems;

import java.util.HashMap;
import java.util.HashSet;

/**
 * You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.
 *
 * Return the number of consistent strings in the array words.
 *
 *
 *
 * Example 1:
 *
 * Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
 * Output: 2
 * Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 * Example 2:
 *
 * Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
 * Output: 7
 * Explanation: All strings are consistent.
 * Example 3:
 *
 * Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
 * Output: 4
 * Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 104
 * 1 <= allowed.length <= 26
 * 1 <= words[i].length <= 10
 * The characters in allowed are distinct.
 * words[i] and allowed contain only lowercase English letters.
 */
public class P1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;

        //Create a full HashSet of alphabet characters
        HashSet<Character> alphabet = new HashSet<>();
        for(int i = 0; i < 26; i++){
            alphabet.add((char) ('a' + i));
        }

        //Removed all of the allowed characters from the hashset
        for(int i = 0; i < allowed.length(); i++){
            alphabet.remove(allowed.charAt(i));
        }

        //Now we go through each word and check if the characters in each word are indie the not
        //allowed left over hashset
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                if(alphabet.contains(word.charAt(i))) { break; }
                if(i + 1 == word.length()){ counter ++; }
            }
        }

        return counter;

    }
}
