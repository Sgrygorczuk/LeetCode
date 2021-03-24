package com.leet_code.game.problems;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class P125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if(s.length() == 1){ return true; }

            s = s.toLowerCase();
            String workString = s;
            for(int i = 0; i < s.length(); i++) {
                if ( s.charAt(i) < 48 ||  s.charAt(i) > 122 || (s.charAt(i) > 57 && s.charAt(i) < 97)) {
                    workString = workString.replace(s.substring(i, i + 1) + "", "");
                }
            }

            if(workString.length() == 1){ return true; }

            for(int i = 0; i < workString.length()/2; i++){
                if(workString.charAt(i) != workString.charAt(workString.length() - 1 - i)){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean slowMethod(String s){
        //If the length is 1 it's true
        if(s.length() == 1){ return true; }

        //Make everything lowercase
        s = s.toLowerCase();
        //Get a second string to tweak the first one
        String workString = s;
        //Go through all the character and get rid of anything that's not a number or letter
        for(int i = 0; i < s.length(); i++) {
            if ( s.charAt(i) < 48 ||  s.charAt(i) > 122 || (s.charAt(i) > 57 && s.charAt(i) < 97)) {
                workString = workString.replace(s.substring(i, i + 1) + "", "");
            }
        }

        //If we come out that it's only a letter then it's true
        if(workString.length() == 1){ return true; }

        //Go through the two halfs and see if they match
        for(int i = 0; i < workString.length()/2; i++){
            if(workString.charAt(i) != workString.charAt(workString.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
