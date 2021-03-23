package com.leet_code.game.problems;

/**
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 *
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 *
 * Input: nums = [3,7]
 * Output: 12
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class P1464 {
    class Solution {
        public int maxProduct(int[] nums) {
            int num1 = 0;
            int num2 = 0;

            //Looks for the largest numbers going througg
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];

                //Checks if the current number is bigger than 1
                //If it is we update num2 and num1
                if (current >= num1) {
                    num2 = num1;
                    num1 = current;
                }
                //If current not bigger than 1 but bigger than 2 update 2
                else if (current > num2) {
                    num2 = current;
                }
            }

            //Once the serache is done we reutrn the value
            return (num1 - 1) * (num2 - 1);
        }
    }

    public int slowSolution(int[] nums){
        int maxValue = 0;

        //Just go through the array twice and see all possible choices of the multiplication
        for(int i = 0; i < nums.length; i ++){
            for(int j = i; j < nums.length; j++){
                if(maxValue < (nums[i] - 1)*(nums[j] - 1) && i != j){
                    maxValue = (nums[i] - 1)*(nums[j] - 1);
                }
            }
        }
        return maxValue;
    }
}
