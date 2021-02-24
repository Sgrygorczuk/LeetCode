package com.leet_code.game.problems;

/**
 * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
 *
 * Return the sum of all the unique elements of nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,2]
 * Output: 4
 * Explanation: The unique elements are [1,3], and the sum is 4.
 * Example 2:
 *
 * Input: nums = [1,1,1,1,1]
 * Output: 0
 * Explanation: There are no unique elements, and the sum is 0.
 * Example 3:
 *
 * Input: nums = [1,2,3,4,5]
 * Output: 15
 * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class P1748 {
    class Solution {
        public int sumOfUnique(int[] nums) {
            //Create an array that the max size
            int[] possibleNumbers = new int[101];
            int output = 0;

            //Goes through each element and adds up how many times it occurs
            for(int num : nums){ possibleNumbers[num]++; }

            //Checks if it only occured once we add it to the sum
            for(int i = 0; i < possibleNumbers.length; i++){
                if(possibleNumbers[i] == 1){
                    output += i;
                }
            }

            return output;
        }
    }
}
