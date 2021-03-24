package com.leet_code.game.problems;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class P66 {
    class Solution {
        public int[] plusOne(int[] digits) {
            //Add +1 to the last index of the array
            digits[digits.length-1]++;
            //We go through the array form the back
            for(int i = digits.length - 1; i > -1; i--){
                //If we're at the very front of the array and the number is greater than 9
                //We have to expand the array
                if(i == 0 && digits[i] > 9){
                    //Make the new array 1 bigger
                    int[] newDigits = new int[digits.length+1];
                    //Set that old number to be 0
                    digits[i] = 0;
                    //Set the front to be 1
                    newDigits[0] = 1;
                    //Copy the old array into new one
                    System.arraycopy(digits, 0, newDigits, 1, digits.length);
                    //Return the new bigger array
                    return newDigits;
                }
                //If we are not at the front and we find a 10 we carry the one to the index lower
                if(digits[i] > 9){
                    digits[i] = 0;
                    digits[i-1]++;
                }
            }
            return digits;
        }
    }
}
