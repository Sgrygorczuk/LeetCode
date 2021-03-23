package com.leet_code.game.problems;

import java.util.Arrays;

/**
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 *
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 *
 * For example, inverting [0,1,1] results in [1,0,0].
 *
 *
 * Example 1:
 *
 * Input: image = [[1,1,0],[1,0,1],[0,0,0]]
 * Output: [[1,0,0],[0,1,0],[1,1,1]]
 * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
 * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
 * Example 2:
 *
 * Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
 * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 *
 * Constraints:
 *
 * n == image.length
 * n == image[i].length
 * 1 <= n <= 20
 * images[i][j] is either 0 or 1.
 */
public class P823 {

    class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            //So we go through each row
            for(int[] ints : image){
                //In each row we first swap them placements of the the front pointer and end pointer
                //ints
                for(int i = 0; i < ints.length/2; i ++){
                    int temp = ints[ints.length - 1 + i];
                    ints[ints.length - 1 - i] = ints[i];
                    ints[i] = temp;
                }
                //Once that's done we then invert all the positions
                for(int i = 0; i < ints.length; i++){
                    if(ints[i] == 0){ ints[i] = 1; }
                    else { ints[i] = 0; }
                }
            }

            return image;
        }
    }
}
