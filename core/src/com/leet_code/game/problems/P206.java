package com.leet_code.game.problems;

import java.util.ArrayList;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class P206 {


    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode reverseList(ListNode head) {
            return iterativeWay(head);
        }

        /**
         * My janky way of iteratively reverse a linked list
         * @param head
         * @return
         */
        private ListNode iterativeWay(ListNode head){
            ListNode traveler = head;
            //First we go through the original list grabbing everything along the way
            ArrayList<ListNode> arrayList = new ArrayList();
            while(traveler != null){
                arrayList.add(traveler);
                traveler = traveler.next;
            }

            //Then we go from the back and reattached the saved addresses
            for(int i = 0; i < arrayList.size(); i++){
                if(i < arrayList.size()-1) {
                    arrayList.get(arrayList.size() - 1 - i).next = arrayList.get(arrayList.size() - 2 - i);
                }
                else{
                    arrayList.get(arrayList.size() - 1 - i).next = null;
                }
            }

            //As long as we were given a linked list return the inverse
            if(arrayList.size() > 0){
                return arrayList.get(arrayList.size()-1);
            }
            //Else give back null
            else{
                return null;
            }
        }
    }
}
