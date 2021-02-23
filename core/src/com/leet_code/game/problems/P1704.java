package com.leet_code.game.problems;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "book"
 * Output: true
 * Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
 * Example 2:
 *
 * Input: s = "textbook"
 * Output: false
 * Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
 * Notice that the vowel o is counted twice.
 * Example 3:
 *
 * Input: s = "MerryChristmas"
 * Output: false
 * Example 4:
 *
 * Input: s = "AbCdEfGh"
 * Output: true
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 1000
 * s.length is even.
 * s consists of uppercase and lowercase letters.
 */
public class P1704 {
    class Solution {
        public boolean halvesAreAlike(String s) {
            int[] alphabet = new int[26];
            int index;

            //Make everything lowercase
            s = s.toLowerCase();

            //Split in half based on if it's odd or even
            if(s.length()%2 == 0){ index = s.length()/2; }
            else{ index = s.length()/2 + 1; }

            //Go through all the letters in the given word, first half adds whatever letters
            //We find second half subtracts
            for(int i = 0; i < s.length()/2; i++){
                alphabet[s.charAt(i) - 'a']++;
                alphabet[s.charAt(i + index) - 'a']--;
            }

            //Does a sum of all of the vowels, if the sum is 0 then both sides
            //have equal amount of vowels
            return alphabet[0] + alphabet[4] + alphabet[8] + alphabet[14] + alphabet[20]== 0;
        }
    }
}
