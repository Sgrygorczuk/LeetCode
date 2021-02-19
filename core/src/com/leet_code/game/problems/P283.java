package com.leet_code.game.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class P283 {
    class Solution {
        public void moveZeroes(int[] nums) {

        }
    }

    /**
     * My first attempt, moving the numbers one by one to the next box by switching it's neighboor
     * Goes like this:
     * 0 1 0 3 12
     * 1 0 0 3 12
     * 1 0 3 0 12
     * 1 0 3 12 0
     *
     * Then we look at 1 again just in case it was a 0 and we contuie up the array till we find another 0
     *1 0 3 12 0
     *1 3 0 12 0
     *1 3 12 0 0
     *1 3 12 0 0  <-- Pushes the 0 that was at the end to the second to last
     *
     * Very slow but it works
     */
    public void firstTry(int[] nums) {

        int zeroCount = 0;
        int movesCount = 0;
        for(int num : nums){ if(num == 0){zeroCount++;}}

        //Looks at the beginning of array
        for(int i = 0; i < nums.length; i++){
            //If we found a zero we do push
            if(nums[i] == 0) {
                //Push all of the items till we hit the end
                for (int j = 0; j < nums.length - i; j++) {
                    if (j + i + 1< nums.length - 1) {
                        int temp = nums[i + j + 1];
                        nums[i + j + 1] = nums[i +j];
                        nums[i +j] = temp;
                    } else {
                        break;
                    }
                }
                //If we moved a zero let's step back and check if the new item at
                //last position is a 0
                movesCount++;
                if(movesCount < zeroCount){i--;}
            }
        }
    }
}
