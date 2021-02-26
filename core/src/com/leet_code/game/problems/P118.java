package com.leet_code.game.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */
public class P118 {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            //The output list
            List<List<Integer>> output = new ArrayList<>();

            for(int i = 0; i < numRows; i++){
                //Create a new array and add a 1 to the first column
                List<Integer> newRow = new ArrayList<>();
                newRow.add(1);
                //As long as we have one entry we can look back
                if(i > 0) {
                    //We will have additional i entries per row
                    //Second row has +1 entries
                    for (int j = 0; j < i; j++) {
                        //Last entry is always a 1
                        if (j == i - 1) { newRow.add(1); }
                        //All other entires are sums between current and next entry from
                        //previous row
                        else {
                            newRow.add(output.get(i - 1).get(j) + output.get(i - 1).get(j + 1));
                        }
                    }
                }
                output.add(newRow);
            }
            return output;
        }
    }
}
