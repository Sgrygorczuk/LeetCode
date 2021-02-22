package com.leet_code.game.problems;

import java.util.ArrayList;

/**
 * Given a positive integer num consisting only of digits 6 and 9.
 *
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 *
 *
 * Example 1:
 *
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 * Example 2:
 *
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 * Example 3:
 *
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 */
public class P1323 {
    class Solution {
        public int maximum69Number (int num) {
            int maxNumber = num;
            int index = -1;
            int length = 0;

            //Goes through the number and looks for the largest instance of 6
            //and find the spot it existed in
            while(num % 10 > 0){
                //Check for the last instance of a 6
                if(num % 10 == 6){ index = length; }
                //Counts how long the int is
                length++;
                num = num/10;
            }

            //If we did find a 6 we subtract that and add a 9
            //This will give us the max number
            if(index != -1) {
                maxNumber -= 6 * (int) Math.pow(10, index);
                maxNumber += 9 * (int) Math.pow(10, index);
            }

            return maxNumber;
        }


        /**
         * Doesn't work, is too complcated
         * @param num
         * @return
         */
        private int attemptTwo(int num){
            ArrayList<Integer> nums = new ArrayList<>();
            int maxNum = num;

            while(num % 10 > 0){
                nums.add(num%10);
                num = num/10;
            }

            for(int i = 0; i < nums.size(); i++){
                int testNum = 0;
                for(int j = 0; j < nums.size(); j++){
                    if(i != j){
                        testNum += nums.get(j) * (int) Math.pow(10, nums.size() - 1 - j);
                    }
                    else{
                        if(nums.get(i) == 6) {
                            testNum += 9 * (int) Math.pow(10, nums.size() - 1 - j);
                        }
                        else{
                            testNum += 6 * (int) Math.pow(10, nums.size() - 1 - j);
                        }
                    }
                }
                System.out.println(testNum);
                if(maxNum < testNum){
                    maxNum = testNum;
                }
            }

            return maxNum;
        }

        /**
         * Was trying to break it down into lenght, too complicated
         * @param num
         */
        private int attemptOne(int num){
            int maxNumber = num;
            int length = 0;

            if(num % 1000 > 0){
                length = 4;
            }
            else if(num % 100 > 0){
                length = 3;
            }
            else if(num % 10 > 0){
                length = 2;
            }
            else{
                length = 1;
            }

            if(length == 1){ return 9; }

            for(int i = 0; i < length; i++){

            }
            return maxNumber;
        }

    }
}
