package com.leet_code.game.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class P1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //Checks if there is a number in the numMap that will add up to the target
                if (numMap.containsKey(target - nums[i])) {
                    //If there is get their index and return it
                    return new int[]{numMap.get(target - nums[i]), i};
                }
                //If not just add that number and index to the map
                else {
                    numMap.put(nums[i], i);
                }
            }
            return null;
        }
    }

    private int[] dumbBruteWay(int[] nums, int target){
        int[] output = new int[2];
        //Just go through it till it works, very bad
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j){
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        return output;
    }
}
