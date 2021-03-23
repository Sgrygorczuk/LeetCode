package com.leet_code.game.mocks;

public class Mock_1_Failed_Second_Question {
    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     *
     *
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s[i] is a printable ascii character.
     */
    class Solution1 {
        public void reverseString(char[] s) {
            for(int i = 0; i < s.length/2; i++){
                char temp = s[s.length - 1 - i];
                s[s.length - 1 - i] = s[i];
                s[i] = temp;
            }
        }
    }

    /**
     *Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.
     *
     *
     *
     * Example 1:
     *
     * Input: mat = [[1,0,1],
     *               [1,1,0],
     *               [1,1,0]]
     * Output: 13
     * Explanation:
     * There are 6 rectangles of side 1x1.
     * There are 2 rectangles of side 1x2.
     * There are 3 rectangles of side 2x1.
     * There is 1 rectangle of side 2x2.
     * There is 1 rectangle of side 3x1.
     * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
     * Example 2:
     *
     * Input: mat = [[0,1,1,0],
     *               [0,1,1,1],
     *               [1,1,1,0]]
     * Output: 24
     * Explanation:
     * There are 8 rectangles of side 1x1.
     * There are 5 rectangles of side 1x2.
     * There are 2 rectangles of side 1x3.
     * There are 4 rectangles of side 2x1.
     * There are 2 rectangles of side 2x2.
     * There are 2 rectangles of side 3x1.
     * There is 1 rectangle of side 3x2.
     * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
     * Example 3:
     *
     * Input: mat = [[1,1,1,1,1,1]]
     * Output: 21
     * Example 4:
     *
     * Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
     * Output: 5
     *
     *
     * Constraints:
     *
     * 1 <= rows <= 150
     * 1 <= columns <= 150
     * 0 <= mat[i][j] <= 1
     */
    class Solution {
        public int numSubmat(int[][] mat) {
            int solution = 0;


            //1x1 This counts how many 1x1 we have
            for (int[] row : mat) {
                for (int i : row) {
                    if (i == 1) {
                        solution++;
                    }
                }
            }

            //Rows
            //This counts all the diffrent rows of 1s we find, so any 2x1, 3x1 and so on.
            for (int[] row : mat) {
                int counter = 0;
                for (int i = 0; i < row.length; i++) {
                    //If we have a 1 we collect that as a row of collections
                    if (row[i] == 1) {
                        counter++;
                    }
                    //If we hit a 0 then we break that row into all possible smaller rows
                    //A 1x3 also holds two 1x2s
                    //A 1x4 holds two 1x3s and 5 1x2s
                    if (row[i] == 0 && counter > 1) {
                        solution += breakdown(counter);
                        counter = 0;
                    }
                    else if (row[i] == 0 && counter > 0) {
                        counter = 0;
                    }

                    if (i + 1 == mat[0].length && counter > 1) {
                        solution += breakdown(counter);
                    }
                }
            }


            //Column
            //This counts all the diffrent rows of 1s we find, so any 2x1, 3x1 and so on.
            for (int i = 0; i < mat[0].length; i++) {
                int counter = 0;
                for (int j = 0; j < mat.length; j++) {
                    //If we have a 1 we collect that as a collumnn of collections
                    if (mat[j][i] == 1) {
                        counter++;
                    }
                    //If we hit a 0 then we break that row into all possible smaller rows
                    //A 1x3 also holds two 1x2s
                    //A 1x4 holds two 1x3s and 5 1x2s

                    if (mat[j][i] == 0 && counter > 1) {
                        solution += breakdown(counter);
                        counter = 0;
                    } else if (mat[j][i] == 0 && counter > 0) {
                        counter = 0;
                    }

                    if (j + 1 == mat.length && counter > 1) {
                        solution += breakdown(counter);
                    }

                }
            }

            //Combos
            return solution;
        }


        /**
         * Takes the length of the row or column and breaks down how many possible rows/columns
         * you could make out of it
         * @param i the length of row or column
         * @return possible num of sub rows/columns within it
         */
        public int breakdown(int i){
            int returnVal = 0;
            for(int j = 1; j < i + 1; j++){
                returnVal += i-j;
            }
            return returnVal;
        }
    }
}
