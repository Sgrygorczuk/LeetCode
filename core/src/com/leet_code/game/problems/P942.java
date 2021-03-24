package com.leet_code.game.problems;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class P942 {
    class Solution {
        public int[] diStringMatch(String S) {
            int iCounter = 0;               //Counts from bottom
            int dCounter = S.length();      //Counts from top
            int[] outputArray = new int[S.length() + 1];
            for(int i = 0; i < S.length(); i++){
                //If I appears add
                if(S.charAt(i) == 'I'){
                    outputArray[i] = iCounter;
                    iCounter++;
                }
                //If D appears sub
                else if(S.charAt(i) == 'D'){
                    outputArray[i] = dCounter;
                    dCounter--;
                }
            }
            //Last one is whatever we didn't use
            outputArray[S.length()] = iCounter;
            return outputArray;
        }
    }
}
