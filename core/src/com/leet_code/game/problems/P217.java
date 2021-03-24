package com.leet_code.game.problems;

import java.util.HashSet;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class P217 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            //Get a hash set
            HashSet<Integer> numbers = new HashSet<>();
            //Run through all the numbers
            for (int num : nums) {
                //If it already exits in the set then we got a double
                if (numbers.contains(num)) { return true; }
                //We add the number to hash set to compare later
                else { numbers.add(num); }
            }
            //If we found no doubles return false
            return false;
        }
    }
}
