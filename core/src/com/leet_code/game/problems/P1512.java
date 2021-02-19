package com.leet_code.game.problems;

import java.util.Arrays;

/**
 * Given an array of integers nums.
 *
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 *
 * Return the number of good pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 *
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */

public class P1512 {
    public int numIdenticalPairs(int[] nums) {
        //Sum of all of the good points
        int goodPairCounter = 0;

        //Runs through the initial array, passes on the current index, it's value and a sub array to compare it to
        for(int i = 0; i < nums.length; i++){
            //Takes in whatever is the result of that subindex
            goodPairCounter += goodPairs(i, nums[i], Arrays.copyOfRange(nums, i, nums.length));
        }

        return goodPairCounter;
    }

    /**
     *
     * @param index - Last index in the orignal array
     * @param currentPoint - Value that that given index
     * @param subNums - The SubArray from last index to end of original array
     * @return - Number of good values in this subarray
     */
    int goodPairs(int index, int currentPoint, int[] subNums){
        int goodPairCounter = 0;
        for(int i = 0; i < subNums.length; i++){
            if(currentPoint == subNums[i] && index < index + i){goodPairCounter++;}
        }
        return goodPairCounter;
    }
}
