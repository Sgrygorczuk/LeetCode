package com.leet_code.game.problems;

/**
 *
 You are given an integer n, the number of teams in a tournament that has strange rules:

 If the current number of teams is even, each team gets paired with another team. A total of n / 2 matches are played, and n / 2 teams advance to the next round.
 If the current number of teams is odd, one team randomly advances in the tournament, and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
 Return the number of matches played in the tournament until a winner is decided.



 Example 1:

 Input: n = 7
 Output: 6
 Explanation: Details of the tournament:
 - 1st Round: Teams = 7, Matches = 3, and 4 teams advance.
 - 2nd Round: Teams = 4, Matches = 2, and 2 teams advance.
 - 3rd Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 Total number of matches = 3 + 2 + 1 = 6.
 Example 2:

 Input: n = 14
 Output: 13
 Explanation: Details of the tournament:
 - 1st Round: Teams = 14, Matches = 7, and 7 teams advance.
 - 2nd Round: Teams = 7, Matches = 3, and 4 teams advance.
 - 3rd Round: Teams = 4, Matches = 2, and 2 teams advance.
 - 4th Round: Teams = 2, Matches = 1, and 1 team is declared the winner.
 Total number of matches = 7 + 3 + 2 + 1 = 13.


 Constraints:

 1 <= n <= 200

 */
public class P1688 {
    class Solution {
        /**
         * Recurse answer, we sum up the number of matches by
         * getting the inital number of n/2 or (n-1)/2 and recursively call this function
         * to find out what the next outcome will be until we hit 1 team
         * @param n
         * @return
         */
        public int numberOfMatches(int n) {
            int numberOfMatches = 0;
            //If only one team is moving forward there is no more matches
            if(n == 1){ return 0; }
            //If there is an even number of teams moving forward we had n/2 matches
            //And we will have extra n/2 matches
            if(n%2 == 0){ numberOfMatches = n/2 + numberOfMatches(n/2); }
            //If the number of teams is odd we had (n-1)/2 matches
            //And we will have (n-1)/2+1 matches
            else{ numberOfMatches = (n - 1) / 2 +  numberOfMatches((n - 1) / 2 + 1); }

            return numberOfMatches;
        }
    }
}
