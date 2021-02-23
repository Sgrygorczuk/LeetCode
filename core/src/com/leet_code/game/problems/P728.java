package com.leet_code.game.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class P728 {
    class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> outputList = new ArrayList<>();

            //We go through all possible digits between the two given points
            for (int i = left; i < right + 1; i++) {
                //If its only single digit we just add it
                if (i < 9) { outputList.add(i); }
                //Else we have to scan it
                else {
                    //We get the num which we will slowly break down (Ex. 128)
                    int num = i;
                    //We get the current digit we're looking at (Ex. 1 , 2 ,8)
                    int currentNum;
                    while (num != 0) {
                        //We get the currentNum (128%10 = 8)
                        currentNum = num % 10;
                        //We make sure that it's not 0, we can't have numbers that contain zero
                        if (currentNum == 0) { break; }
                        //We make sure that the num can be divided by it (128%8) else we move on
                        if (i % currentNum != 0) { break; }
                        //We go to the next number
                        num /= 10;
                    }
                    //If we managed to go through all number num = 0 and we can add that number to the roster
                    if (num == 0) { outputList.add(i); }
                }
            }

            return outputList;
        }
    }
}
