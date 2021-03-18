package com.leet_code.game.problems;

import java.util.HashSet;

/**
 * Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode"
 * return 2.
 *
 *
 * Note: You may assume the string contains only lowercase English letters.
 */
public class P387 {

    class Solution {
        public int firstUniqChar(String s) {
            //We set up the alphabet array
            int[] alphabet = new int[26];
            //Do one pass where we count how many time each letter occurs
            for(int i = 0; i < s.length(); i++){
                alphabet[s.charAt(i) - 97]++;
            }
            //Do a second pass where we check in order if that letter occurred
            //more than once, if not that's our guy
            for(int i = 0; i < s.length(); i++){
                if(alphabet[s.charAt(i) - 97] == 1){
                    return i;
                }
            }
            return -1;
        }
    }
}
