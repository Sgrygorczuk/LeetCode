package com.leet_code.game.problems;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class P709 {
    class Solution {
        public String toLowerCase(String str) {
            //Goes through each char in the string,
            //If it falls into the capital range 65-90 we add 32 to move it to it's
            //lower case version
            for(int i = 0; i < str.length(); i++){
                if((int) str.charAt(i) >= 65 && (int) str.charAt(i) <= 90){
                    str = str.replace(str.charAt(i), (char) (str.charAt(i) + 32));
                }
            }
            return str;
        }
    }
}
