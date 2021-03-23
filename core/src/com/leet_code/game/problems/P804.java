package com.leet_code.game.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *
 * For convenience, the full table for the 26 letters of the English alphabet is given below:
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
 *
 * Return the number of different transformations among all words we have.
 *
 * Example:
 * Input: words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * The transformation of each word is:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * There are 2 different transformations, "--...-." and "--...--.".
 * Note:
 *
 * The length of words will be at most 100.
 * Each words[i] will have length in range [1, 12].
 * words[i] will only consist of lowercase letters.
 */
public class P804 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {

            //Grabs the more code to use later
            String[] morseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            HashSet<String> translation = new HashSet<>();

            //We do two loops one through each word and then one through each letter in that word
            for(String word : words){
                String translatedWord = "";
                //When looking at each letter we translate it
                for(int i = 0; i < word.length(); i++) { translatedWord += morseCode[word.charAt(i) - 97]; }
                //Once we translated it we check if we already seen a word like that, if not we save it
                if(!translation.contains(translatedWord)) { translation.add(translatedWord); }
            }

            //We then give back the number of saved words
            return translation.size();
        }
    }
}
