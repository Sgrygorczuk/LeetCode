package com.leet_code.game.problems;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class P824 {
    class Solution {
        public String toGoatLatin(String S) {
            //Keeps track of how many words we've looked at
            int counter = 0;
            StringBuilder output = new StringBuilder();
            //Goes through the original string
            for (int i = 0; i < S.length(); i++) {
                //Finds the nearest space " "
                int spaceIndex = S.indexOf(" ", i);
                //Checks if you we have any spaces left, if not then we just look till end of string
                if(spaceIndex == -1) { spaceIndex = S.length(); }
                //Vowel Check a, e, i, o, or u
                if(S.toLowerCase().charAt(i) == 'a' || S.toLowerCase().charAt(i)  == 'e' || S.toLowerCase().charAt(i)  == 'i' || S.toLowerCase().charAt(i)  == 'o' || S.toLowerCase().charAt(i)  == 'u'){
                    output.append(S, i, spaceIndex).append("ma");
                }
                //Else does consonant
                else{
                    output.append(S, i + 1, spaceIndex).append(S, i, i + 1).append("ma");
                }
                //Adds a to the end for counter amount of words we've looked at
                for(int j = 0; j < counter; j++){ output.append("a"); }
                //Adds a space at the end
                if(spaceIndex != S.length()){output.append(" ");}
                //Moves the pointer to the space location
                i = spaceIndex;
            }
            return output.toString();
        }
    }
}
