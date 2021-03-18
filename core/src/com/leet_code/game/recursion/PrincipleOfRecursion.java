package com.leet_code.game.recursion;

/*
You might wonder how we can implement a function that calls itself. The trick is that each time a recursive function calls itself, it reduces the given problem into subproblems. The recursion call continues until it reaches a point where the subproblem can be solved without further recursion.

A recursive function should have the following properties so that it does not result in an infinite loop:

A simple base case (or cases) — a terminating scenario that does not use recursion to produce an answer.
A set of rules, also known as recurrence relation that reduces all other cases towards the base case.
Note that there could be multiple places where the function may call itself.
 */

public class PrincipleOfRecursion {

    /**
     * linked Node for a linked list
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Constructor with an example
     */
    public PrincipleOfRecursion() {
        char[] array = new char[]{'a','b','c','d'};
        char[] array2 = new char[]{'a','b','c','d'};
        print(array);
        System.out.print(reverserArray(array2, 0));
    }

    /**
     * In between method to acess the recursive method
     * @param string given string
     */
    public void print(char [] string){ printChar(string, string.length-1); }

    /**
     * Prints out the last index given, if index is less than 0 or if the array length is 0
     *  it returns
     * @param string provided string
     * @param index last index
     */
    private void printChar(char[] string, int index){
        if(index < 0 || string.length == 0){ return;}
        System.out.println(string[index]);
        index--;
        printChar(string, index);
    }

    /**
     * Returns a reversed array
     * @param s given string
     * @param index current index we're looking at
     * @return a reversed array
     */
    private char[] reverserArray(char [] s, int index){
        if(s.length == 0 || s.length == 1 || index == s.length/2){ return s;}
        char temp = s[index];
        s[index] = s[s.length-1-index];
        s[s.length-1-index] = temp;
        index++;
        reverserArray(s, index);
        return s;
    }

    /**
     * @param s given string
     * @param index current index we're looking at
     * @return a reversed array
     */
    private char[] reverserNodes(char [] s, int index){
        if(s.length == 0 || s.length == 1 || index == s.length/2){ return s;}
        char temp = s[index];
        s[index] = s[s.length-1-index];
        s[s.length-1-index] = temp;
        index++;
        reverserArray(s, index);
        return s;
    }
}
