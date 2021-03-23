package com.leet_code.game.problems;

import com.badlogic.gdx.math.MathUtils;

import javax.xml.soap.Node;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class P1290 {

      public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public int getDecimalValue(ListNode head) {
            int decimalNumber = 0;      //Number we're gonan keep track of
            int counter = 0;            //Where we are on the second run
            int size = 0;               //Size of the linked list

            //We travel once to find out the linked lists size
            ListNode travel = head;
            while(travel != null){
                size++;
                travel = travel.next;
            }

            //Reset to start
            travel = head;

            //We go through it agian add up any 1's we find
            while (travel != null){
                if(travel.val == 1){ decimalNumber += (Math.pow(2 * travel.val, size - 1 - counter));}
                counter++;
                travel = travel.next;
            }

            return decimalNumber;
        }
    }
}
