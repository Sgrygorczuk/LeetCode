package com.leet_code.game.problems;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 */
public class P136 {
    public int singleNumber(int[] nums) {
        /**
         * Best way to do it is with a HashTable gotta look up how to do those
         */

        /**
         * This is my first attempt
         */
        //If the lenght is 1 just give whatever we have
        if(nums.length == 1){return nums[0];}
        //Otherwise run through two for loops as you scan the data
        //If you find that there is no repeate give the value back
        else {
            int output = 0;
            boolean found = false;
            for (int i = 0; i < nums.length; i++){
                    if(found){break;}
                    output = nums[i];
                for(int j = 0; j < nums.length; j++){
                    if(nums[i] == nums[j] && i != j){
                        found = false;
                        break;
                    }
                    found = true;
                }
            }
            return output;
        }
    }
}
;