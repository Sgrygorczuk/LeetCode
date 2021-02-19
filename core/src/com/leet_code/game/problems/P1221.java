package com.leet_code.game.problems;

/**
 *
 Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

 Given a balanced string s, split it in the maximum amount of balanced strings.

 Return the maximum amount of split balanced strings.



 Example 1:

 Input: s = "RLRRLLRLRL"
 Output: 4
 Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 Example 2:

 Input: s = "RLLLLRRRLR"
 Output: 3
 Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
 Example 3:

 Input: s = "LLLLRRRR"
 Output: 1
 Explanation: s can be split into "LLLLRRRR".
 Example 4:

 Input: s = "RLRRRLLRLL"
 Output: 2
 Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'


 Constraints:

 1 <= s.length <= 1000
 s[i] is either 'L' or 'R'.
 s is a balanced string.

 */
public class P1221 {
    public int balancedStringSplit(String s) {
        int counter = 0;
        int rCounter = 0;
        int lCounter = 0;

        //Goes through the whole string
        for(int i = 0; i < s.length(); i++){
            //Checks for the number of times R and L occur
            if(s.startsWith("R", i)){ rCounter++; }
            else if(s.startsWith("L", i)){ lCounter++; }
            //If they occur equal number of times count that as a grouping and
            //reset them to start again
            if(rCounter == lCounter){
                counter++;
                rCounter = lCounter = 0;
            }
        }
        return counter;
    }
}
