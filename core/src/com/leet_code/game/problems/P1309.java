package com.leet_code.game.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 */
public class P1309 {
    class Solution {
        public String freqAlphabets(String s) {
            //Build a table to have a quick change
            Map<String, String> myMap = new HashMap<String, String>();
            myMap.put("26#", "z");
            myMap.put("25#", "y");
            myMap.put("24#", "x");
            myMap.put("23#", "w");
            myMap.put("22#", "v");
            myMap.put("21#", "u");
            myMap.put("20#", "t");
            myMap.put("19#", "s");
            myMap.put("18#", "r");
            myMap.put("17#", "q");
            myMap.put("16#", "p");
            myMap.put("15#", "o");
            myMap.put("14#", "n");
            myMap.put("13#", "m");
            myMap.put("12#", "l");
            myMap.put("11#", "k");
            myMap.put("10#", "j");
            myMap.put("9", "i");
            myMap.put("8", "h");
            myMap.put("7", "g");
            myMap.put("6", "f");
            myMap.put("5", "e");
            myMap.put("4", "d");
            myMap.put("3", "c");
            myMap.put("2", "b");
            myMap.put("1", "a");

            //The output string
            StringBuilder output = new StringBuilder();

            //Going through the list
            for(int i = 0; i < s.length(); i++) {
                //Checks if we have enough room and if we do if we see  #
                if (i + 2 < s.length() && s.substring(i, i + 3).contains("#")){
                        //If we see it we check what this translates to in the table and add it to
                        //The string
                        output.append(myMap.get(s.substring(i, i + 3)));
                        //Skip extra forward
                        i += 2;
                }
                else{
                    //Otherwise just translate the current i char
                    output.append(myMap.get(s.substring(i, i + 1)));
                }
            }

            return String.valueOf(output);
        }
    }
}
