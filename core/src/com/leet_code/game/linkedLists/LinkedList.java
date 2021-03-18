package com.leet_code.game.linkedLists;

    /*
    Unlike the array, we are not able to access a random element in a singly-linked list in
    constant time. If we want to get the ith element, we have to traverse from the head node one
    by one. It takes us O(N) time on average to visit an element by index, where N is the length of
    the linked list.

    For instance, in the example above, the head is the node 23. The only way to visit the 3rd
    node is to use the "next" field of the head node to get to the 2nd node (node 6); Then with the
     "next" field of node 6, we are able to visit the 3rd node.

    You might wonder why the linked list is useful though it has such a bad performance
    (compared to the array) in accessing data by index. We will introduce the insert and delete
    operations in next two articles and you will realize the benefit of the linked list.

    After that, we provide an exercise for you to design your own singly linked list.
    */

import java.util.HashMap;
import java.util.HashSet;

public class LinkedList {
    Node head;

    class Node {
        int val;
        Node next;
        Node(int x){ val = x;}
    }

    public LinkedList(){}

    /**
     * Gets the value at the given index
     * @param index place we want to look at
     * @return value of that node
     */
    public int get(int index){
        //If the list is empty return -1
        if(head == null){ return -1; }
        //If index is 0 return head value
        if(index == 0){ return head.val; }

        //If we have a list we go through it till desired index
        Node travel = head;
        int counter = 0;
        while(travel.next != null && counter < index){
            travel = travel.next;
            counter++;
        }

        //If the index is beyond the list return -1
        if(travel.next == null  && counter < index){ return -1; }

        //If we find it return the value
        return travel.val;
    }

    /**
     * Creates a new head
     * @param val value of the new head
     */
    public void addAtHead(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /**
     * Creates a node at the end of the list
     * @param val value of the new node
     */
    public void addAtTail(int val){
        //If the list is empty make it a head
        if(head == null){
            head =  new Node(val);
            return;
        }

        //Go to the end of the list
        Node travel = head;
        while(travel.next != null){
            travel = travel.next;
        }

        //Set up a new node at the end
        travel.next = new Node(val);
    }

    /**
     * Creates a node at the given index
     * @param index place
     * @param val value
     */
    public void addAtIndex(int index, int val){
        //If index is 0 create a new head
        if(index == 0){
            addAtHead(val);
            return;
        }

        //If we have a list we go through it till desired index
        Node travel = head;
        int counter = 0;
        while(travel.next != null && counter < index - 1){
            travel = travel.next;
            counter++;
        }

        //Do Nothing if index is out of bounds
        if(travel.next == null && counter + 1 < index){
            return;
        }


        //If the index is in the middle of the list
        Node node = new Node(val);
        node.next = travel.next;
        travel.next = node;
    }

    /**
     * Deletes a node at the given index
     * @param index place
     */
    public void deleteAtIndex(int index){
        //Checks if the list is empty if so do nothing
        if(head == null){ return; }
        //If the index is at head move head to the next node
        if(index == 0){
            head = head.next;
            return;
        }

        //If we do have a list we set up a travel and counter to see if we reached desired index
        Node travel = head;
        int counter = 0;
        while(travel.next != null && counter < index - 1){
            travel = travel.next;
            counter++;
        }

        //If the index is passed the size of the list then we do nothing
        if(travel.next == null){ return; }

        //If we find the index and there is a next node we just attach this node's next to the one
        // of it's next
        travel.next = travel.next.next;
    }

    /**
     * Prints the entire list
     */
    public void printList(){
        Node travel = head;
        while(travel.next != null){
            System.out.println(travel.val);
            travel = travel.next;
        }
        System.out.println(travel.val);
    }

    /**
     * Checks if the list ever goes back in on itself (cycles)
     * @param head the start of the linked list
     * @return tells us if there is cycle or not
     */
    public boolean hasCycle(Node head) {
        //If the list is empty there is no cycle
        if(head == null){ return false; }

        //We create a Hash set that will collect each node we
        //pass by if we pass by that node again then we're in a cycle
        //Else if we find a null then there is no cycle
        HashSet nodeCollection = new HashSet<Node>();
        Node travel = head;
        while(travel.next != null){
            if(nodeCollection.contains(travel)){
                return true;
            }
            nodeCollection.add(travel);
            travel = travel.next;
        }
        return false;
    }

    /**
     * Checks if there is a cycle and if there is one it tells us which node is the start of it
     * @param head start of the linked list
     * @return the node which starts the cycle
     */
    public Node indexWhereCycleOccurs(Node head) {
        //If the list is empty there is no cycle so output is null
        if(head == null){ return null; }

        //We create a Hash set that will collect each node we
        //pass by if we pass by that node again then we're in a cycle and we give that node
        //Else if we find a null then there is no cycle
        HashSet nodeCollection = new HashSet<Node>();
        Node travel = head;
        while(travel.next != null){
            if(nodeCollection.contains(travel)){
                return travel;
            }
            nodeCollection.add(travel);
            travel = travel.next;
        }
        return null;
    }

    /**
     * Tells us if two linked lists intersect
     * @param headA first linked list start
     * @param headB second linked list start
     * @return tells us if the two are connected or not
     */
    public Node doLinkedListIntersect(Node headA, Node headB) {
        //If either lists are empty then they cant intersect
        if(headA == null || headB == null){ return null; }

        //Creates a HashSet to collect all the nodes in the first list
        HashSet nodeCollectionA = new HashSet<Node>();
        Node travelA = headA;
        while(travelA != null){
            if(nodeCollectionA.contains(travelA)){
                return travelA;
            }
            nodeCollectionA.add(travelA);
            travelA = travelA.next;
        }

        //Then we go through the second list and see if any of the nodes occurred in the first
        //list by checking the nodes in the hash set
        Node travelB = headB;
        while(travelB != null){
            if(nodeCollectionA.contains(travelB)){
                return travelB;
            }
            travelB = travelB.next;
        }
        return null;
    }

    /**
     * Remove a node from linked list n spots from the end of the list
     * @param head given head
     * @param index how many spots from end we want to remove it from
     * @return the head of the new list
     */
    public Node removedNthFromEnd(Node head, int index) {
        //If index is 0 create a new head
        if(head == null ){return null; }

        //If we have a list we go through it till desired index
        Node travel = head;         //Used to get to the end of the list
        Node travelDelayed = head;  //Used to get to the index we want to delete
        int counter = 0;
        while(travel.next != null){
            //Only update if we're past the index we would sub from the lenght
            if(counter >= index){ travelDelayed = travelDelayed.next; }
            travel = travel.next;
            counter++;
        }

        //If the counter is 0 we remove the head
        if(counter == 0){
            head = null;
            return head;
        }
        //If we're still at the head and index is bigger than head position remove head
        if(travelDelayed == head && counter - index < 0){
            head = head.next;
            return head;
        }

        //Otherwise remove whatever is next
        travelDelayed.next = travelDelayed.next.next;
        return head;
    }

    public Node reverseList(Node head, int index) {
        return head;
    }

}