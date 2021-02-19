package com.leet_code.game.problems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?


 */
public class P242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            return tryAlphabet(s, t);
        }

        public boolean tryAlphabet(String s, String t){
            //We get an array of 26 letters
            int[] alphabetCount = new int[26];

            if(s.length() == t.length()){
                if(s.length() == 0){return true;}

                //We go through both strings, if the letter occurs in
                //s we add if the letter occurs in t we sub
                //if all the same letters exist between the two
                //then all letters should be zero
                for(int i = 0; i < s.length(); i++){
                    alphabetCount[s.charAt(i) - 'a'] += 1;
                    alphabetCount[t.charAt(i) - 'a'] -= 1;
                }

                //Checks if it's all 0 if not it's not an anagram
                for(int i : alphabetCount){
                    if(i != 0){return false;}
                }
                return true;
            }
            else{
                return false;
            }
        }

        /**
         * My attemot at making the things with chars, got the idea to turn
         * them into numbers and add them up for the max value but that doesn't account
         * for other letter combos adding up to the same max number
         * @param s
         * @param t
         * @return
         */
        public boolean tryOneChars(String s, String t){
            int sValue = 0;
            int tValue = 0;

            if(s.length() == t.length()){
                for(int i = 0; i < s.length(); i++){
                    sValue += s.charAt(i);
                    tValue += t.charAt(i);
                }
                return sValue == tValue;
            }
            else{
                return false;
            }
        }

        /**
         * Map attempt, collect all the given characters counter them and
         * see if they match in count, very very slow
         */
        public boolean mapTry(String s, String t){
            Map<Character, Integer> sMap = new HashMap<Character, Integer>();
            Map<Character, Integer> tMap = new HashMap<Character, Integer>();
            if(s.length() == t.length()){
                if(s.length() == 0){return true;}
                //Goes through each entry and puts it in the map
                for(int i = 0; i < s.length(); i++){
                    if(sMap.containsKey(s.charAt(i))){
                        int value = sMap.get(s.charAt(i));
                        value++;
                        sMap.put(s.charAt(i), value);
                    }
                    else{
                        sMap.put(s.charAt(i), 1);
                    }

                    if(tMap.containsKey(t.charAt(i))){
                        int value = tMap.get(t.charAt(i));
                        value++;
                        tMap.put(t.charAt(i), value);
                    }
                    else{
                        tMap.put(t.charAt(i), 1);
                    }
                }

                //Checks if the entices coexist and if they have the same count of letters
                for(Map.Entry<Character,Integer> entry : sMap.entrySet()){
                    if(!tMap.containsKey(entry.getKey())){
                        return false;
                    }
                    else{
                        if(!tMap.get(entry.getKey()).equals(entry.getValue())){
                            return false;
                        }
                    }
                }
                return true;

            }
            else{
                return false;
            }
        }
    }
}
