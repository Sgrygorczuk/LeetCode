package com.leet_code.game.problems;

/**
 *
 Given an integer n, return any array containing n unique integers such that they add up to 0.



 Example 1:

 Input: n = 5
 Output: [-7,-1,1,3,4]
 Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 Example 2:

 Input: n = 3
 Output: [-1,0,1]
 Example 3:

 Input: n = 1
 Output: [0]


 Constraints:

 1 <= n <= 1000
 */
public class P1304 {
    class Solution {
        public int[] sumZero(int n) {
            //This one does it in pairs
            int[] ans = new int[n];
            int lo = -1;
            int hi = 1;
            for (int i = 0; i < n-1; i+=2) {
                ans[i] = lo;
                ans[i+1] = hi;
                lo--;
                hi++;
            }
            return ans;
        }

        /**
         * It works but is rather cheap in the execution
         * @param n
         * @return
         */
        private int[] secondTry(int n){
            int[] outputArray = new int[n];
            //If the size is 0 then just return 0
            if(n == 1){
                outputArray[0] = 0;
                return outputArray;
            }
            //If the size is more than zero just make them equal to i and
            //the last one will be the negative sum of them all
            int sum = outputArray[0] = -1;
            for(int i = 1; i < outputArray.length; i++){
                if(i + 1 == outputArray.length){
                    outputArray[i] = -sum;
                }
                else {
                    outputArray[i] = i;
                    sum += i;
                }
            }
            return outputArray;
        }

        /**
         * Too complicated, there must be a simler way
         * @param n
         * @return
         */
        private int[] firstTry(int n){
            int[] array = new int[n];
            int range = 41;
            int[] unique = new int [range];
            boolean inserted = false;

            if(n == 1){
                array[0] = 0;
                return array;
            }

            int sum = 0;

            for(int i = 0; i < array.length; i++){
                if(i + 1 == array.length){
                    array[i] = -sum;
                }
                else {
                    int roll = (int) (Math.random() * (range/2 - (-range/2) + 1) + -range/2);
                    while (!inserted) {
                        if (unique[roll + range/2] == 0 & roll != 0) {
                            unique[roll + range/2]++;
                            array[i] = roll;
                            sum += array[i];
                            inserted = true;
                        }
                        else {
                            roll = (int) (Math.random() * (range/2 - (-range/2) + 1) + -range/2);
                        }
                    }
                }
                inserted = false;
            }
            return array;
        }
    }
}
