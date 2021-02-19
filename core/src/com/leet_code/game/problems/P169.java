package com.leet_code.game.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 */
public class P169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int value = 0;
            int key = 0;

            //Creates a map of all the entries in the array and counts how many time each occurs
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    value = map.get(num);
                    value++;
                    map.put(num, value);
                } else {
                    map.put(num, 1);
                }
            }

            value = 0;
            //Goes through those entries finds the one with the highest value and
            //returns that key
            for (Map.Entry<Integer,Integer> entry : map.entrySet())
                if(value < entry.getValue()) {
                    value = entry.getValue();
                    key = entry.getKey();
                }

            return key;
        }
    }
}
